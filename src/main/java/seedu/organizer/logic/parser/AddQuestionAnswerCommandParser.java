package seedu.organizer.logic.parser;

import static seedu.organizer.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.organizer.commons.core.Messages.MESSAGE_REPEATED_SAME_PREFIXES;
import static seedu.organizer.logic.parser.CliSyntax.PREFIX_ANSWER;
import static seedu.organizer.logic.parser.CliSyntax.PREFIX_QUESTION;

import java.util.stream.Stream;

import seedu.organizer.commons.exceptions.IllegalValueException;
import seedu.organizer.logic.commands.AddQuestionAnswerCommand;
import seedu.organizer.logic.parser.exceptions.ParseException;

//@@author dominickenn
/**
 * Parses input arguments and creates a new AddQuestionAnswerCommand object
 */
public class AddQuestionAnswerCommandParser implements Parser<AddQuestionAnswerCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the AddQuestionAnswerCommand
     * and returns an AddQuestionAnswerCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddQuestionAnswerCommand parse(String args) throws ParseException {

        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_QUESTION, PREFIX_ANSWER);

        if (!arePrefixesPresent(argMultimap, PREFIX_QUESTION, PREFIX_ANSWER)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    AddQuestionAnswerCommand.MESSAGE_USAGE));
        }

        if (arePrefixesRepeated(argMultimap, PREFIX_QUESTION, PREFIX_ANSWER)) {
            throw new ParseException(String.format(MESSAGE_REPEATED_SAME_PREFIXES, AddQuestionAnswerCommand
                    .MESSAGE_USAGE));
        }
        try {
            String question = ParserUtil.parseQuestion(argMultimap.getValue(PREFIX_QUESTION)).get();
            String answer = ParserUtil.parseAnswer(argMultimap.getValue(PREFIX_ANSWER)).get();
            return new AddQuestionAnswerCommand(question, answer);
        } catch (IllegalValueException ive) {
            throw new ParseException(ive.getMessage(), ive);
        }
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

    //@@author guekling
    /**
     * Returns true if any of the prefixes contains multiple values in the given {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesRepeated(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).anyMatch(prefix -> (argumentMultimap.getSize(prefix) > 1));
    }
    //@@author
}
