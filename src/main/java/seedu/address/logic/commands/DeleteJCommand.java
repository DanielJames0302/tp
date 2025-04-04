package seedu.address.logic.commands;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.JobTitle;

/**
 * Deletes a predefined job role.
 */
public class DeleteJCommand extends Command {
    public static final String COMMAND_WORD = "deleteJ";
    public static final String MESSAGE_SUCCESS = "Job role deleted: %s";
    public static final String MESSAGE_JOB_ROLE_NOT_FOUND = "Error: Job role not found: %s";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes input job role from saved list.\n"
            + "Parameters: jobTitle \n"
            + "Example: " + COMMAND_WORD + " Software Engineer";

    private final JobTitle title;

    public DeleteJCommand(JobTitle title) {
        this.title = title;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        if (!model.hasJobTitle(title)) {
            throw new CommandException(String.format(MESSAGE_JOB_ROLE_NOT_FOUND, title));
        }
        model.deleteJobTitle(title);
        return new CommandResult(String.format(MESSAGE_SUCCESS, title));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof DeleteJCommand)) {
            return false;
        }

        DeleteJCommand otherDeleteJCommand = (DeleteJCommand) other;
        return title.equals(otherDeleteJCommand.title);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("targetJobTitle", title)
                .toString();
    }
}
