package seedu.organizer.model.recurrence;

import java.util.Objects;

//@@author natania
/**
 * Represents a Task's recurrence in the organizer book.
 */

public class Recurrence {

    public final boolean isRecurring;
    public final int recurrenceGroup;

    /**
     * Constructs a {@code Recurrence}.
     */
    public Recurrence() {
        this.isRecurring = false; // false when task is not recurring, true when otherwise
        this.recurrenceGroup = 0; // dummy group
    }


    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Recurrence // instanceof handles nulls
                && this.isRecurring == (((Recurrence) other).isRecurring))
                && this.recurrenceGroup == (((Recurrence) other).recurrenceGroup)); // state check
    }

    @Override
    public int hashCode() {
        return Objects.hash(isRecurring, recurrenceGroup);
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        return "Recurrence: " + isRecurring;
    }

}


