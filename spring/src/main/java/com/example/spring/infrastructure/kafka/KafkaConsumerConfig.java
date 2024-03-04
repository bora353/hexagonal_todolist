package com.example.spring.infrastructure.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {

    @Value(value = "${kafka.bootstrapAddress}")
    private String BOOTSTRAP_ADDRESS;

    @Value(value = "${kafka.consumer.group-id}")
    private String GROUP_ID;

    @Bean
    public ConsumerFactory<String, String> consumerFactory(){
        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_ADDRESS);

        // Consumer 그룹은 같은 토픽을 소비하는 Consumer들의 그룹으로,
        // 그룹 내의 모든 Consumer는 토픽의 서로 다른 파티션에서 메시지를 읽어 들입니다.
        // 이를 통해 메시지 처리를 병렬화 하여 처리 속도를 향상시킬 수 있으며,
        // Consumer가 실패할 경우 다른 Consumer가 해당 Consumer의 파티션을 처리하여 고가용성을 제공할 수 있습니다.
        config.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);
        //config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        //config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);
        config.put(ErrorHandlingDeserializer.KEY_DESERIALIZER_CLASS, JsonDeserializer.class);
        config.put(ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS, JsonDeserializer.class.getName());

        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest"); // 첫 레코드부터 읽음

        return new DefaultKafkaConsumerFactory<>(config);
    }

    // Spring의 @KafkaListener 어노테이션이 붙은 메서드에 주입되어 사용되며,
    // 메시지를 동시에 처리할 수 있는 메시지 리스너 컨테이너를 생성합니다.
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());

        return factory;
    }
}