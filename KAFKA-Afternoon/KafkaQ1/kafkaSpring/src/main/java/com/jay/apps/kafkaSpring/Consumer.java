package com.jay.apps.kafkaSpring;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Consumer{
    private static final String TOPIC = "AfterPass";
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate2;
    @KafkaListener(topics = "BeforePass",groupId = "group_id")
    public void consumeMessage(String message){
        this.kafkaTemplate2.send(TOPIC,message);
        System.out.println(message);
    }



    //	    public void sendMessage2(String message) {
//
//				//System.out.println(message);
//
//			}
    @Bean
    public NewTopic createTopic1(){

        return new NewTopic(TOPIC,3,(short) 1);
    }








}