package com.craftDemo.KafkaProducer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;



@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "playersScores";

    public void sendMessage(String playerName, int playerScore) {
        String message = String.format("Player: %s, Score: %d", playerName, playerScore);
        kafkaTemplate.send(TOPIC, message);
    }
}