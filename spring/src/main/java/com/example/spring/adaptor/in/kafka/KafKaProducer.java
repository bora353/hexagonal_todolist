package com.example.spring.adaptor.in.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class KafKaProducer {

    @Value(value = "${message.topic.name}")
    private String TOPIC_NAME;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(Message message){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String stringMessage = objectMapper.writeValueAsString(message);
            kafkaTemplate.send(TOPIC_NAME, stringMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    // future 비동기적 작업이 완료되면 호출되는 콜백을 등록
    public void sendWithCallback(Message message) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String stringMessage = objectMapper.writeValueAsString(message);

        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(TOPIC_NAME, stringMessage);
        future.whenComplete((result, ex) -> {
            if (ex == null){
                System.out.println("Sent message: " + message);
            } else{
                System.out.println("Failed to send message: " + message);
            }
        });
    }
}
