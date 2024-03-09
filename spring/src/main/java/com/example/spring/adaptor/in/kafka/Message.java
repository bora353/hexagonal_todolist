package com.example.spring.adaptor.in.kafka;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    private String name;
    private String message;
}
