package com.example.spring.infrastructure.kafka;


import com.example.spring.adaptor.in.kafka.Message;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafKaProducerConfig {

    @Value(value = "${kafka.bootstrapAddress}")
    private String BOOTSTRAP_ADDRESS;

    @Bean
    public ProducerFactory<String, String> producerFactory(){
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_ADDRESS);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, JsonSerializer.class); // 지금은 키 사용 안함
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class); // 객체를 -> JSON 형식

        return new DefaultKafkaProducerFactory<>(config);
    }

    // KafkaTemplate는 Spring Kafka에서 제공하는 Kafka Producer를 Wrapping 한 클래스입니다.
    // KafkaTemplate는 Kafka에 메시지를 보내는 여러 메서드를 제공하며,
    // 이 메서드를 사용하여 브로커로 메시지를 보내기 위해 직접 Kafka Producer API를 사용하는 대신,
    // send와 같은 메서드를 통해 더 편리하고 간결한 코드로 메시지를 보낼 수 있습니다.
    @Bean
    public KafkaTemplate<String, String> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }
}
