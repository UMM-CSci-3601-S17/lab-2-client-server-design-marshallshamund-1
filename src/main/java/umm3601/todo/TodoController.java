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

    public Todo[] listTodos(Map<String, String[]> queryParameter) {
        Todo[] filteredTodos = todos;

        //limited list of todos
        if (queryParameter.containsKey("limit")) {
            int listLimit = Integer.parseInt(queryParameter.get("limit")[0]);
            filteredTodos = limitedList(filteredTodos, listLimit);
        }

        //status todos

        if(queryParameter.containsKey("status")) {
            Boolean progress = false;
            String stateOfTodo = queryParameter.get("status")[0];
            if(stateOfTodo.equals("complete")){
                progress = true;
            }
            filteredTodos = filterStatusTodos(filteredTodos, progress);
        }
        return filteredTodos;
    }

    // Returns a Single one
    public Todo getTodo(String id){
        return Arrays.stream(todos).filter(x -> x._id.equals(id)).findFirst().orElse(null);
    }

    //Return specified number of todos
    public Todo[] limitedList(Todo[] filteredTodos, int listLimit){
        filteredTodos = new Todo[listLimit];

        for(int i = 0; i < listLimit; i++) {
            filteredTodos[i] = todos[i];
            }

        return filteredTodos;
    }

    //returns completed or incomleted todos
    public Todo[] filterStatusTodos(Todo[] statusTodos, boolean todoStatus){
        return Arrays.stream(statusTodos).filter(x -> x.status == todoStatus).toArray(Todo[]::new);
    }


}
