package com.example.spring.adaptor.out.persistence.mapper;

import com.example.spring.adaptor.out.persistence.entity.TodoEntity;
import com.example.spring.domain.Todo;
import org.springframework.stereotype.Component;

@Component
public class TodoMapper {

    public Todo toDomain(TodoEntity entity){
        return Todo.builder()
                //.id(entity.getId())
                .name(entity.getName())
                .complete(false)
                .content(entity.getContent())
                .description(entity.getDescription())
                .build();
    }

    public TodoEntity toEntity(Todo domain){
        return TodoEntity.builder()
                //.id(domain.getId())
                .complete(false)
                .content(domain.getContent())
                .description(domain.getDescription())
                .name(domain.getName())
                .build();
    }

}
