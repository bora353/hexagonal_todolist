package com.example.spring.adaptor.in.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "${message.topic.name}", groupId = "${kafka.consumer.group-id}")
    public void listener(String jsonMessage){
        try {
            Message message = objectMapper.readValue(jsonMessage, Message.class);
            System.out.println("Kafka Listen>>> name : " + message.getName() + " message : " + message.getMessage());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
