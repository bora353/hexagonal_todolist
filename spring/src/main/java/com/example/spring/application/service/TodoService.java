package com.example.spring.application.service;

import com.example.spring.application.port.in.TodoUseCase;
import com.example.spring.application.port.out.TodoPort;
import com.example.spring.domain.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService implements TodoUseCase {

    @Autowired
    private final TodoPort todoPort;

    //    @Autowired
    //    private final SendMessageQueue todoRepository;

    @Override
    public List<Todo> getAll() {
        return todoPort.findAll();
    }

    @Override
    public Todo create(Todo todo) {
        return todoPort.save(todo);
    }

    @Override
    public void delete(Long id) {
        todoPort.delete(id);
    }

}
