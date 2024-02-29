package com.example.spring.adaptor.in.kafka;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafKaTopicConfig { // 카프카 토픽생성

    @Value(value = "${kafka.bootstrapAddress}")
    private String BOOTSTRAP_ADDRESS;

    @Value(value = "${kafka.consumer.group-id}")
    private String GROUP_ID;

    @Value(value = "${message.topic.name}")
    private String TOPIC_NAME1;

    @Bean
    public KafkaAdmin kafkaAdmin(){
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_ADDRESS);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic topic1(){
        return new NewTopic(TOPIC_NAME1, 1, (short) 1);
    }


}
