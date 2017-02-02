package umm3601.todo;

import org.junit.Test;
import umm3601.user.User;

import static junit.framework.TestCase.assertEquals;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class completeTest {
    @Test
    public void statusComplete() throws IOException {
        TodoController todoController = new TodoController();
        Map<String, Boolean> queryParameter = new HashMap<>();
        queryParameter.put("status", true);
        Todo[] completeTodos = todoController.listStatusTodos(queryParameter);
        Todo completed = completeTodos[0];
        assertEquals("It's True", true, completed.status);
        assertEquals("Incorrect Nummber Of Todos", 143, completeTodos.length);
    }

    @Test
    public void statusIncomplete() throws IOException{
        TodoController todoController = new TodoController();
        Map<String, Boolean> queryParameter = new HashMap<>();
        queryParameter.put("status", false);
        Todo[] incompleteTodos = todoController.listStatusTodos(queryParameter);
        assertEquals("Incorrect Nummber Of Todos", 157, incompleteTodos.length);
    }
}
