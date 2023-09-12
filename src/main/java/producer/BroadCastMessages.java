package producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Configuration
public class BroadCastMessages {
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @EventListener(ApplicationReadyEvent.class)
    public void produce(){
        Map<String, Object> jsonMessage = new HashMap<>();
        jsonMessage.put("name", "sumit");
        jsonMessage.put("age", 21);
        jsonMessage.put("email", "dhanorkar@gmail.com");
        simpMessagingTemplate.convertAndSend("/queue", jsonMessage);
    }
}
