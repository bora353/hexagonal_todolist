package com.example.spring.domain;

import lombok.Builder;
import lombok.Data;

@Data
public class Todo {

    //private final Long id;
    private final String content;
    private final String name;
    private final String description;
    private boolean complete;

    @Builder
    public Todo(String content, String name, String description, boolean complete){
        this.content = content;
        this.name = name;
        this.description = description;
        //this.id = id;
    }

}
