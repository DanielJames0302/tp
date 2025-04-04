package seedu.address.logic.commands;

import java.util.stream.Collectors;

import javafx.collections.ObservableList;
import seedu.address.model.Model;
import seedu.address.model.person.JobTitle;

/**
 * Lists all predefined job roles.
 */
public class ListJCommand extends Command {
    public static final String COMMAND_WORD = "listJ";
    public static final String MESSAGE_SUCCESS = "Here are job roles that you have saved:\n%s";
    public static final String MESSAGE_EMPTY_SUCCESS = "There are no job roles saved in the application.";

    @Override
    public CommandResult execute(Model model) {
        ObservableList<JobTitle> roles = model.getFilteredJobTitleList();
        String rolesDisplay = roles.stream().map(j -> j.value).sorted().collect(Collectors.joining("\n"));
        if (rolesDisplay.isEmpty()) {
            return new CommandResult(String.format(MESSAGE_EMPTY_SUCCESS, ""));
        }
        return new CommandResult(String.format(MESSAGE_SUCCESS, rolesDisplay));
    }
}
