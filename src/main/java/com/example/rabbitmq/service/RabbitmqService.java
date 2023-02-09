package com.example.rabbitmq.service;

import com.example.rabbitmq.model.Student;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitmqService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${rabbitmq.exchange:exchange}")
    String exchange;

    @Value("${rabbitmq.routingKey:routingkey}")
    String routingKey;

    public void sendToRabbitmq(Student student){

        amqpTemplate.convertAndSend(exchange, routingKey, student);

    }
}
