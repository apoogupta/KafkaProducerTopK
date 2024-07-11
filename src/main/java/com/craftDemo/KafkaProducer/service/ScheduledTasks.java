package com.craftDemo.KafkaProducer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ScheduledTasks {

    @Autowired
    private KafkaProducerService producerService;

    private Random random = new Random();
    private String[] playerNames = {"Alice", "Bob", "Charlie", "David","Jack"};


    @Scheduled(fixedRate = 10000)
    public void sendMessageEveryFiveSeconds() {
        sendRandomMessage();
    }

    private void sendRandomMessage() {
        String playerName = playerNames[random.nextInt(playerNames.length)];
        int playerScore = random.nextInt(100);
        producerService.sendMessage(playerName, playerScore);
    }
}
