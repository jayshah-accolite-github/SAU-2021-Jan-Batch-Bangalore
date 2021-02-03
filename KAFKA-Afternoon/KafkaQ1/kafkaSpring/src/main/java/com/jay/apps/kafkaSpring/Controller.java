package com.jay.apps.kafkaSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    private final Producer producer;

    @Autowired
    public Controller(Producer producer) {
        this.producer = producer;
    }
    @PostMapping("/publish/{message}")
    public void messageToTopic(@PathVariable String message){

        this.producer.sendMessage(message);
    }

    @GetMapping("/test")
    public String test()
    {
        return "success";
    }
}