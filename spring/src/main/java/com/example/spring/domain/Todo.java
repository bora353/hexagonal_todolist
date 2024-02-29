package com.example.spring.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Todo {

    private final Long id;
    private final String content;
    private final String name;
    private final String description;
    private boolean complete;

    @Builder
    public Todo(String content, String name, String description, boolean complete, Long id){
        this.content = content;
        this.name = name;
        this.description = description;
        this.id = id;
    }

}
