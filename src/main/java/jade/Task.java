package jade;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    protected String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    protected String statusFormatter() { return (isDone ? "1" : "0"); }

    protected void mark() {
        this.isDone = true;
    }

    protected void unMark() {
        this.isDone = false;
    }

    public boolean isSameDate(LocalDate date) {
        return false;
    }

    public String taskFormatter() {
        return String.format("T | %s | %s\n", statusFormatter(), description);
    }

    @Override
    public String toString() {
        return String.format("[%s] %s",this.getStatusIcon(),  this.description);
    }
}
