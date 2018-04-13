package seedu.organizer.logic.parser;

//@@author agus
import static seedu.organizer.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.organizer.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.organizer.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.organizer.testutil.TypicalIndexes.INDEX_FIRST_TASK;
import static seedu.organizer.testutil.TypicalIndexes.INDEX_SECOND_TASK;

import org.junit.Test;

import seedu.organizer.logic.commands.DeleteSubtaskCommand;

/**
 * Test scope: similar to {@code DeleteCommandParserTest}.
 *
 * @see DeleteCommandParserTest
 */
public class DeleteSubtaskCommandParserTest {

    private DeleteSubtaskCommandParser parser = new DeleteSubtaskCommandParser();

    @Test
    public void parse_validArgs_returnsSelectCommand() {
        assertParseSuccess(parser, "1 2", new DeleteSubtaskCommand(INDEX_FIRST_TASK, INDEX_SECOND_TASK));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "a", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                DeleteSubtaskCommand.MESSAGE_USAGE));

        assertParseFailure(parser, "1", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                DeleteSubtaskCommand.MESSAGE_USAGE));

        assertParseFailure(parser, "1 2 3", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                DeleteSubtaskCommand.MESSAGE_USAGE));
    }
}
