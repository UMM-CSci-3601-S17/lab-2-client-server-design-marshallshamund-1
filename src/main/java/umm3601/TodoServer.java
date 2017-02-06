package umm3601;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import umm3601.todo.TodoController;

import java.io.IOException;

import static spark.Spark.*;
import static umm3601.Server.wrapInJson;

public class TodoServer {
    public static void main(String[] args) throws IOException {
        staticFiles.location("/public");
        Gson gson = new Gson();
        TodoController todoController = new TodoController();

        //Redirect for the Todos form
        redirect.get("/todos", "/todos.html");

        //redirect for the About page
        redirect.get("/about" , "/about.html");

        //Redirect for the home page
        redirect.get("/index" , "/index.html");

        //list of todos
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

    public static JsonObject wrapInJson(String name, JsonElement jsonElement) {
        JsonObject result = new JsonObject();
        result.add(name, jsonElement);
        return result;
    }

    }

