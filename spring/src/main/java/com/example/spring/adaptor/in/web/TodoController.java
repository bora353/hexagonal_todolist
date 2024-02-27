package com.example.spring.adaptor.in.web;

import com.example.spring.application.port.in.TodoUseCase;
import com.example.spring.domain.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api")
public class TodoController {

    private final TodoUseCase todoUseCase;

    @GetMapping("/")
    public String index() {
        return "spring!";
    }

    @GetMapping("/todoList")
    public ResponseEntity<List<Todo>> getTodoList() {
        return ResponseEntity.ok().body(todoUseCase.getAll());
    }

    @PostMapping("/todoList")
    public ResponseEntity<Void> createTodo(@RequestBody Todo todoCreate) {
        todoUseCase.create(todoCreate);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/todoList")
    public ResponseEntity<Void> deleteTodo(@RequestParam Long id) {
        todoUseCase.delete(id);
        return ResponseEntity.ok().build();
    }
}
