package umm3601;

import com.google.gson.Gson;
import umm3601.todo.TodoController;

import java.io.IOException;

import static spark.Spark.*;
import static umm3601.Server.wrapInJson;

/**
 * Created by gordo580 on 2/3/17.
 */
public class TodoServer {
    public static void main(String[] args) throws IOException{
        staticFiles.location("/public");
        Gson gson = new Gson();
        TodoController todoController = new TodoController();

        //Redirect for list of todos
        get("api/todos", (req, res) -> {
            res.type("application/json");
            return wrapInJson("todos", gson.toJsonTree(todoController.listTodos(req.queryMap().toMap())));
        });

        get("api/todos/:id", (req, res) -> {
        res.type("application/json");
        String id = req.params("id");
        return gson.toJson(todoController.getTodo(id));
        });


    }
}
