package jade.data;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TaskListTest {
    @Test
    public void mark_validIndex_success() throws Exception {
        TaskList testTaskList = new TaskList(List.of(new Todo("first"), new Todo("second")));
        testTaskList.mark(0);
        assertEquals(true, testTaskList.get(0).isDone);
        testTaskList.mark(1);
        assertEquals(true, testTaskList.get(1).isDone);
    }

    @Test
    public void mark_invalidIndex_exceptionThrown() {
        try {
            TaskList testTaskList = new TaskList(List.of(new Todo("first")));
            testTaskList.mark(-1);
            fail();
        } catch (Exception e) {
            assertEquals("Index: -1 Size: 1", e.getMessage());
        }
    }

    @Test
    public void unmark_validIndex_success() throws Exception {
        TaskList testTaskList = new TaskList(List.of(new Todo("first", true), new Todo("second", true)));
        testTaskList.unmark(0);
        assertEquals(false, testTaskList.get(0).isDone);
        testTaskList.unmark(1);
        assertEquals(false, testTaskList.get(1).isDone);
    }

    @Test
    public void unmark_invalidIndex_exceptionThrown() {
        try {
            TaskList testTaskList = new TaskList(List.of(new Todo("first", true)));
            testTaskList.unmark(2);
            fail();
        } catch (Exception e) {
            assertEquals("Index: 2 Size: 1", e.getMessage());
        }
    }
}