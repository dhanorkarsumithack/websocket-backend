package com.sumit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller
@EnableScheduling
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate websocket;

//    @MessageMapping("/send-data")
//    public void broadcastData(@Payload String message) {
//        System.out.println(message);
//        Random random = new Random();
//        Map<String, Object> jsonMessage = new HashMap<>();
//        jsonMessage.put("messageType", "sample");
//        jsonMessage.put("data", "Sample JSON Data 1");
//        jsonMessage.put("randomNumber", random.nextInt(100));
//
//        this.websocket.convertAndSend("/queue", jsonMessage);
//    }

    @Scheduled(fixedRate = 4000)
    public void sendDummyMessage() {
        Random random = new Random();
        Map<String, Object> jsonMessage = new HashMap<>();
        jsonMessage.put("messageType", "babaji "+random.nextInt(10));
        jsonMessage.put("data", "Sample JSON Data 1");
        jsonMessage.put("randomNumber", random.nextInt(100));
        System.out.println(jsonMessage);
        this.websocket.convertAndSend("/queue", jsonMessage);
    }

}

