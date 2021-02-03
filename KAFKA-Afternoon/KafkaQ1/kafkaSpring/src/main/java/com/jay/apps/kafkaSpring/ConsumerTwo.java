package com.jay.apps.kafkaSpring;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerTwo {
    @KafkaListener(topics = "AfterPass",groupId = "group_id")
    public void consumeMessage(String message){
        System.out.println(message);

    }

}