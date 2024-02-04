package jade.commands;

import jade.data.TaskList;
import jade.exception.JadeException;
import jade.storage.Storage;
import jade.ui.Ui;

/**
 * The <code>MarkCommand</code> object represents the command to mark a task as done.
 */
public class MarkCommand extends Command {
    private final int index; // the index of the task to be marked

    /**
     * Class constructor specifying the index of the task to be marked.
     */
    public MarkCommand(int index) {
        this.index = index;
    }

    /**
     * @inheritDoc This implementation prints a mark message after the task is marked.
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws JadeException {
        if (index <= 0 || index > taskList.size()) {
            throw new JadeException("\tPlease input a valid number to mark done.");
        }
        taskList.mark(index - 1);
        ui.printMessage(String.format("\tNice, I've marked this task as done:\n\t  %s", taskList.get(index - 1)));
    }

    /**
     * @inheritDoc The MarkCommand does not indicate the exit of the program.
     */
    @Override
    public boolean shouldExit() {
        return false;
    }
}
