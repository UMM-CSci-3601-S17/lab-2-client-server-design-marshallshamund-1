package umm3601.todo;

import org.junit.Test;
import umm3601.user.User;

import static junit.framework.TestCase.assertEquals;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class completeTest {
    @Test
    public void statusTrue() throws IOException {
        TodoController todoController = new TodoController();
        Map<.status, Boolean> queryParameter = new HashMap<>();
        queryParameter.put("status", true);
        Todo[] completedTodos = todoController.listStatusTodos(queryParameter);
        Todo completed = completedTodos[0];
        assertEquals("It's True", true, completed.status);
        //assertEquals("Not enough Todos" ,50, completedTodos.length);
    }
}
