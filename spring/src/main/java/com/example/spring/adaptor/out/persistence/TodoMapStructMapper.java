package com.example.spring.adaptor.out.persistence;

import com.example.spring.domain.Todo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TodoMapStructMapper {

    TodoMapStructMapper INSTANCE = Mappers.getMapper(TodoMapStructMapper.class);

    Todo toDomain(TodoEntity entity);

    TodoEntity toEntity(Todo todo);

}
