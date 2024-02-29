package com.example.spring.adaptor.in.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KafkaProducerController {

    private final KafKaProducerService kafKaProducerService;

    @PostMapping("/publish")
    public String publishJson(@RequestBody Message message){
        kafKaProducerService.send(message);
        return "publish message >>> name : " + message.getName() + ", message : " + message.getMessage();
    }
}
