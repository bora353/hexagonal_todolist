//package com.example.spring.adaptor.in.kafka;
//
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class KafKaTopicConfig { // 꼭 있어야하나?????
//
//    @Value(value = "${kafka.bootstrapAddress}")
//    private String bootstrapAddress;
//
//    @Value(value = "${message.topic.name}")
//    private String topicName;
//
//    @Value(value = "${greeting.topic.name}")
//    private String partionedTopicName;
//
//    @Value(value = "${filtered.topic.name}")
//    private String filteredTopicName;
//
//    @Value(value = "${partitioned.topic.name}")
//    private String greetingTopicName;
//
////    @Bean
////    public KafkaAdmin kafkaAdmin(){
////        Map<String, Object> configs = new HashMap<>();
////        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
////        return new KafkaAdmin(configs);
////    }
////
////    @Bean
////    public NewTopic topic1(){
////
////    }
////
////    @Bean
////    public NewTopic topic2(){
////
////    }
////
////    @Bean
////    public NewTopic topic3(){
////
////    }
////
////    @Bean
////    public NewTopic topic4(){
////
////    }
//}
