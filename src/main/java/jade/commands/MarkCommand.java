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
    public String execute(TaskList taskList, Storage storage) throws JadeException {
        if (index <= 0 || index > taskList.size()) {
            throw new JadeException("Please input a valid number to mark done.");
        }
        taskList.mark(index - 1);
        String result = String.format("Nice, I've marked this task as done:\n\t  %s", taskList.get(index - 1));
        try {
            storage.saveChange(taskList);
        } catch (JadeException e) {
            return e.getMessage();
        }
        return result;
    }

    /**
     * @inheritDoc The MarkCommand does not indicate the exit of the program.
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
