//package com.example.spring.adaptor.in.kafka;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import static org.mockito.Mockito.doNothing;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//
//@WebMvcTest(KafkaProducerController.class)
//public class KafkaProducerControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private KafKaProducer kafKaProducerService;
//
//    @Test
//    void kafka_결과_확인() throws Exception {
//        Message message = new Message("John", "Hello kafka");
//
//        doNothing().when(kafKaProducerService).send(message);
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/publish")
//                .content(new ObjectMapper().writeValueAsString(message))
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(content().string("publish message >>> name : John, message : Hello Kafka"));
//    }
//}
