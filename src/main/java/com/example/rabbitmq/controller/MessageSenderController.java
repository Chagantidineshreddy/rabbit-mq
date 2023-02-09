package com.example.rabbitmq.controller;

import com.example.rabbitmq.model.Student;
import com.example.rabbitmq.service.RabbitmqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MessageSenderController {

    @Autowired
    private RabbitmqService rabbitmqService;

    @GetMapping("/send-message")
    public void sendMessageToRabbitMq(@RequestParam("id") int id,
                                      @RequestParam("firstname") String firstname,
                                      @RequestParam("lastname") String lastname,
                                      @RequestParam("age") int age){

        rabbitmqService.sendToRabbitmq(new Student(id, firstname, lastname, age));


    }
}
