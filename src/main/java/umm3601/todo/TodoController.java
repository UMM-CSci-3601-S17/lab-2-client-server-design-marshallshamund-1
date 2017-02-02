package umm3601.todo;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by gordo580 on 2/1/17.
 */
public class TodoController {

    private Todo[] todos;

    public TodoController() throws IOException{
        Gson gson = new Gson();
        FileReader reader = new FileReader("src/main/data/todos.json");
        todos = gson.fromJson(reader, Todo[].class);
    }

    public Todo[] listTodos(Map<String, String[]> queryParameter){
        Todo[] filteredTodos = todos;

        return filteredTodos;
    }

    // Returns a Single one
    public Todo getTodo(String id){
        return Arrays.stream(todos).filter(x -> x._id.equals(id)).findFirst().orElse(null);
    }

    //Return specified number of todos
    public Todo[] setNumberOfTodos(Map<String, String[]> queryParameter, int listLimit){
        Todo[] limitedList = new Todo[listLimit];

        for(int i = 0; i < listLimit; i++){
            limitedList[i] = todos[i];
        }

        return limitedList;
    }

    public Todo[] listStatusTodos(Map<String, Boolean> statusQueryParameter){
        Todo[] statusTodos = todos;

        if(statusQueryParameter.containsKey("status")){
            boolean status = statusQueryParameter.get("status");
            statusTodos = filterStatusTodos(statusTodos, status);
        }
        return statusTodos;
    }

    public Todo[] filterStatusTodos(Todo[] statusTodos, boolean todoStatus){
        return Arrays.stream(statusTodos).filter(x -> x.status == todoStatus).toArray(Todo[]::new);
    }


}
