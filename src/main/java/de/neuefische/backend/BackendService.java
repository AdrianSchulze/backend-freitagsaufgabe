package de.neuefische.backend;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class BackendService {
    private final BackendRepo backendRepo;

    public Todo addTodo(Todo todo) {
        return backendRepo.addTodo(todo);
    }

    public List<Todo> getTodoList() {
        return backendRepo.getTodoList();
    }

    public Todo getTodoById(String id) {
        return backendRepo.getTodoById(id);
    }

    public Todo putChangeItem(String id, Todo todo) {
        return backendRepo.putChangeItem(id, todo);
    }

    public Todo deleteItem(String id) {
        Todo newTodo = backendRepo.getTodoById(id);
        return backendRepo.deleteItem(id,newTodo);
    }
}
