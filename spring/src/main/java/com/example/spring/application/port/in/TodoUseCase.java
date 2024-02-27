package com.example.spring.application.port.in;

import com.example.spring.domain.Todo;
import java.util.List;

public interface TodoUseCase {

    public List<Todo> getAll();

    void create(Todo todoCreate);

    void delete(Long id);
}
