package seedu.organizer.model.user;

import static com.google.common.base.Preconditions.checkArgument;
import static seedu.organizer.commons.util.CollectionUtil.requireAllNonNull;

//@@author dominickenn
/**
 * A user class with a question-answer set for password retrieval
 */
public class UserWithQuestionAnswer extends User {

    public static final String MESSAGE_QUESTION_CONSTRAINTS =
            "Questions can take any values, but cannot be blank";
    public static final String MESSAGE_ANSWER_CONSTRAINTS =
            "Answers can take any values, but cannot be blank";

    /*
     * The first character must not be a whitespace, otherwise " " (a blank string) becomes a valid input.
     */
    public static final String QUESTION_VALIDATION_REGEX = "^(?=\\s*\\S).*$";
    public static final String ANSWER_VALIDATION_REGEX = "^(?=\\s*\\S).*$";

    public final String question;
    public final String answer;

    /**
     * Constructs a {@code UserWithQuestionAnswer}.
     *
     * @param username A valid username.
     * @param password A valid password.
     * @param question A valid question.
     * @param answer A valid answer.
     */
    public UserWithQuestionAnswer(String username, String password, String question, String answer) {
        super(username, password);
        requireAllNonNull(question, answer);
        checkArgument(isValidQuestion(question), MESSAGE_QUESTION_CONSTRAINTS);
        checkArgument(isValidAnswer(answer), MESSAGE_ANSWER_CONSTRAINTS);
        this.question = question;
        this.answer = answer;
    }

    /**
     * Returns true if {@code question} is a valid question.
     */
    public static boolean isValidQuestion(String question) {
        return question.matches(QUESTION_VALIDATION_REGEX);
    }

    /**
     * Returns true if {@code answer} is a valid answer.
     */
    public static boolean isValidAnswer(String answer) {
        return answer.matches(ANSWER_VALIDATION_REGEX);
    }
}
