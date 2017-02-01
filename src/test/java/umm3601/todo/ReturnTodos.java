package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by gordo580 on 1/30/17.
 */
public class ReturnTodos {

    @Test
    public void totalTodoCount() throws IOException{
        TodoController todoController = new TodoController();
        Todo[] allTodos = todoController.listTodos(new HashMap<>());
        //We should find out the number of todos we actually have
        assertEquals("Incorrect number of users", 300, allTodos.length);


    }
}

