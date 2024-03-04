package com.example.spring.adaptor.out.persistence.mapper;

import com.example.spring.adaptor.in.web.TodoRequest;
import com.example.spring.adaptor.out.persistence.entity.TodoEntity;
import com.example.spring.domain.Todo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TodoMapStructMapper {

    TodoMapStructMapper INSTANCE = Mappers.getMapper(TodoMapStructMapper.class);

    Todo toDomain(TodoEntity entity);

    @Mapping(target = "id", ignore = true)
    TodoEntity toEntity(Todo todo);

    Todo toDomain(TodoRequest todoRequest);

}
