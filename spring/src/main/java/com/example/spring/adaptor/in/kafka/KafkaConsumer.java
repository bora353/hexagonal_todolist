package com.example.spring.adaptor.in.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

//    @Value(value = "${message.topic.name}")
//    private String topicName;
//    @Value(value = "${kafka.consumer.group-id}")
//    private String groupId;

    public static final String TOPIC_NAME = "mirerotopic";
    public static final String GROUP_ID = "mirerogroup";

    ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = TOPIC_NAME, groupId = GROUP_ID)
    //@KafkaListener(topics = TOPIC_NAME)
    public void listener(String jsonMessage){
        try {
            Message message = objectMapper.readValue(jsonMessage, Message.class);
            System.out.println("Kafka Listen>>> name : " + message.getName() + " message : " + message.getMessage());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
