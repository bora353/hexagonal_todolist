package com.example.spring.application.port.out;


import com.example.spring.domain.Todo;

import java.util.List;

public interface TodoPort {

    List<Todo> findAll();

    Todo save(Todo todo);

    void delete(Long id);
}
