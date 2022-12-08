package de.neuefische.backend;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
@RequiredArgsConstructor
public class BackendController {

    private final BackendService backendService;

    @GetMapping
    public List<Todo> getAllTodos() {
        return backendService.getTodoList();
    }

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable String id) {
        return backendService.getTodoById(id);
    }

    @PostMapping
    public Todo postANewItem(@RequestBody Todo todo) {
        return backendService.addTodo(todo);
    }

    @PutMapping("/{id}")
    public Todo putChangeItem(@PathVariable String id, @RequestBody Todo todo) {
        return backendService.putChangeItem(id, todo);
    }

    @DeleteMapping("/{id}")
    public Todo deleteItem(@PathVariable String id) {
        return backendService.deleteItem(id);
    }
}
