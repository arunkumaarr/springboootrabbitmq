package com.rabbitmq.springbootrabbitmq.controller;

import com.rabbitmq.springbootrabbitmq.producer.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    public Controller(RabbitMQProducer rabbitMQProducer) {
        this.rabbitMQProducer = rabbitMQProducer;
    }

    private RabbitMQProducer rabbitMQProducer;

    @GetMapping("/publish")
    public ResponseEntity<String> SendMessage(@RequestParam("message") String message){
        rabbitMQProducer.sendmessage(message);
        return ResponseEntity.ok("Message sent to RabbitMQ ...");

    }



}
