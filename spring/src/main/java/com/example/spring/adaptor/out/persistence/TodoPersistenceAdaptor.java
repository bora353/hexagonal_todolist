package com.example.spring.adaptor.out.persistence;

import com.example.spring.application.port.out.TodoPort;
import com.example.spring.domain.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class TodoPersistenceAdaptor implements TodoPort {

    private final TodoMapper todoMapper;
    private final TodoJpaRepository jpaRepository;

    @Override
    public List<Todo> findAll() {
        return  jpaRepository.findAll().stream().map(todoMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void save(Todo todo) {
        TodoEntity entity = todoMapper.toEntity(todo);
        jpaRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        Optional<TodoEntity> entity = jpaRepository.findById(id);
        jpaRepository.deleteById(id);
    }
}
