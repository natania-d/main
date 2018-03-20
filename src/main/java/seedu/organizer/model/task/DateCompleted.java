package seedu.organizer.model.task;

import static java.util.Objects.requireNonNull;
import static seedu.organizer.commons.util.AppUtil.checkArgument;

import java.time.LocalDate;

//@@author natania
/**
 * Represents a Task's dateCompleted in the organizer book.
 * Guarantees: immutable; is valid as declared in {@link #isValidDeadline(String)}
 */
public class DateCompleted {

    public static final String MESSAGE_DATECOMPLETED_CONSTRAINTS =
            "Dates should be in the format YYYY-MM-DD, and it should not be blank";

    /*
     * The first character must not be a whitespace, otherwise " " (a blank string) becomes a valid input.
     * Format of string is YYYY-MM-DD.
     */
    public static final String DATECOMPLETED_VALIDATION_REGEX = "\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])";

    public final LocalDate date;

    /**
     * Constructs an {@code DateCompleted}.
     *
     * @param datecompleted A valid date.
     */
    public DateCompleted(String datecompleted) {
        requireNonNull(datecompleted);
        checkArgument(isValidDateCompleted(datecompleted), MESSAGE_DATECOMPLETED_CONSTRAINTS);
        //temporary fix for xml file bug due to PrioriTask's dependence on the current date
        if (datecompleted.equals("current_date")) {
            this.date = LocalDate.now();
        } else {
            //actual code that is run when tests are not running
            this.date = LocalDate.parse(datecompleted);
        }
    }

    /**
     * Constructs a DateCompleted based on the current date
     */
    public DateCompleted() {
        LocalDate currentDate = LocalDate.now();
        requireNonNull(currentDate);
        this.date = currentDate;
    }

    /**
     * Returns true if a given string is a valid task deadline.
     */
    public static boolean isValidDateCompleted(String test) {
        return test.matches("current_date") || test.matches(DATECOMPLETED_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return date.toString();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Deadline // instanceof handles nulls
                && this.date.equals(((Deadline) other).date)); // state check
    }

    @Override
    public int hashCode() {
        return date.hashCode();
    }
}
