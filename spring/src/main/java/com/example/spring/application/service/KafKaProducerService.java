package com.example.spring.application.service;

import com.example.spring.adaptor.in.kafka.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class KafKaProducerService {

    @Value(value = "${message.topic.name}")
    private String TOPIC_NAME;

    private final KafkaTemplate<String, Message> kafkaTemplate;

    public void send(Message message){
        kafkaTemplate.send(TOPIC_NAME, message);
    }

    // future 비동기적 작업이 완료되면 호출되는 콜백을 등록
    public void sendWithCallback(Message message){
        CompletableFuture<SendResult<String, Message>> future = kafkaTemplate.send(TOPIC_NAME, message);
        future.whenComplete((result, ex) -> {
            if (ex == null){
                System.out.println("Sent message: " + message);
            } else{
                System.out.println("Failed to send message: " + message);
            }
        });
    }
}
