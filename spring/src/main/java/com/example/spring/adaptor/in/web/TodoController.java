package com.example.spring.adaptor.in.web;

import com.example.spring.application.port.in.TodoUseCase;
import com.example.spring.domain.Todo;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class TodoController {

    private final TodoUseCase todoUseCase;

    @Autowired
    private Environment environment;

    @GetMapping("/abc")
    public String[] index() {
        log.info(environment.getProperty("spring.datasource.url"));
        return environment.getActiveProfiles();
    }

    @GetMapping("/todoList")
    public ResponseEntity<List<Todo>> getTodoList() {
        return ResponseEntity.ok().body(todoUseCase.getAll());
    }

    @PostMapping("/todoList")
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todoCreate) {
        Todo todoResult = todoUseCase.create(todoCreate);
        return ResponseEntity.status(HttpStatus.CREATED).body(todoResult);
    }

    @DeleteMapping("/todoList/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable("id") Long id) {
        todoUseCase.delete(id);
        return ResponseEntity.ok().build();
    }
}
