package de.neuefische.backend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Repository
public class BackendRepo {

    List<Todo> todoList = new ArrayList<>();

    public Todo addTodo(Todo todo) {
        int generatedString = (int) ((Math.random() * (99999999 - 1111111)) + 1111111);
        todo.setId(String.valueOf(generatedString));
        todoList.add(todo);
        return todo;
    }

    public Todo getTodoById(String id) {
        Todo todo = null;

        for (Todo p : todoList) {
            if (p.getId().equals(id)) {
                todo = p;
                break;
            }
        }
        return todo;
    }

    public Todo putChangeItem(String id, Todo todo) {
        for (Todo newTodo : todoList) {
            if (newTodo.getId().equals(id)) {
                newTodo.setDescription(todo.getDescription());
                newTodo.setStatus(todo.getStatus());
                todo = newTodo;
                break;
            }
        }
        return todo;
    }

    public Todo deleteItem(String id, Todo todo) {
        todoList.remove(getTodoById(id));
        return todo;
    }
}
