package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by gordo580 on 2/3/17.
 */
public class bodyContainsTest {

    @Test
    public void containsThisWord() throws IOException{
        TodoController todoController = new TodoController();
        Map<String, String[]> queryParameter = new HashMap<>();
        queryParameter.put("contains", new String[] {"officia"});
        Todo[] officiaTodos = todoController.listTodos(queryParameter);
        assertEquals("Incorrect number of todos that contain officia", 86, officiaTodos.length);
        queryParameter.put("contains", new String[] {"consequat"});
        Todo[] consequatTodos = todoController.listTodos(queryParameter);
        assertEquals("Incorrect number of todos that contain consequat", 78, consequatTodos.length);
    }
}
