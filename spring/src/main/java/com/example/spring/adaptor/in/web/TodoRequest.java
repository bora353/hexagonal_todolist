package com.example.spring.adaptor.in.web;

import lombok.Data;

@Data
public class TodoRequest {

    private final String content;
    private final String name;
    private final String description;
    private boolean complete;
}
