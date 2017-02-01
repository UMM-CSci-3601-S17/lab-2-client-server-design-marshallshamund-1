package umm3601.todo;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class ReturnTodos {

    @Test
    public void totalTodoCount() throws IOException{
        TodoController todoController = new TodoController();
        Todo[] allTodos = todoController.listTodos(new HashMap<>());
        //We should find out the number of todos we actually have
        assertEquals("Incorrect number of todos", 300, allTodos.length);
    }

    @Test
    public void returnFirstTodoInFullList() throws IOException {
        TodoController todoController = new TodoController();
        Todo[] allTodos = todoController.listTodos(new HashMap<>());
        Todo firstTodo = allTodos[0];
        assertEquals("Incorrect Owner", "Blanche", firstTodo.owner);
        assertEquals("Incorrect Category", "software design", firstTodo.category);
    }

    @Test
    public void returnSevenTodos() throws IOException{
        TodoController todoController = new TodoController();
        Todo[] sevenTodos = todoController.setNumberOfTodos(new HashMap<>(), 7);
        assertEquals("Incorrect number of todos", 7, sevenTodos.length);
    }

    @Test
    public void returnOneHundredTodos() throws IOException{
        TodoController todoController = new TodoController();
        Todo[] oneHundredTodos = todoController.setNumberOfTodos(new HashMap<>(), 100);
        assertEquals("Incorrect Number Of Todos", 100, oneHundredTodos.length);
    }
}

