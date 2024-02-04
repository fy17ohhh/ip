package jade.commands;

import jade.data.Task;
import jade.data.TaskList;
import jade.exception.JadeException;
import jade.storage.Storage;
import jade.ui.Ui;

/**
 * The <code>DeleteCommand</code> object represents the command to delete a task.
 */
public class DeleteCommand extends Command {
    private final int index; // the index of the task to be deleted

    /**
     * Class constructor specifying the index of the task to be deleted.
     */
    public DeleteCommand(int index) {
        this.index = index;
    }

    /**
     * @inheritDoc This implementation prints a delete message after the task is deleted.
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws JadeException {
        if (index <= 0 || index > taskList.size()) {
            throw new JadeException("\tPlease input a valid number to delete the task.");
        }
        Task deletedTask = taskList.get(index - 1);
        taskList.remove(index - 1);
        ui.printMessage(String.format("\tOK, I've deleted this task:\n\t  %s\n\t"
                + "Now you have %d task(s) in the list.", deletedTask, taskList.size()));
    }

    /**
     * @inheritDoc The DeleteCommand does not indicate the exit of the program.
     */
    @Override
    public boolean shouldExit() {
        return false;
    }
}
