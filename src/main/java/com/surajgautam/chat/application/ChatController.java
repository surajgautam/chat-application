package com.surajgautam.chat.application;

import com.surajgautam.chat.application.model.MessageResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class ChatController {

    @Autowired
    private SimpMessagingTemplate template;

    @MessageMapping(value = "/messages")
    @SendTo("/topic/messages")
//    @SendToUser("/private/messages") //user specific message
    public MessageResponseDto sendMessage(@Payload String message) {
        //same as @SendTo
        //template.convertAndSend("/topic/messages", message);

//        same as @SendToUser
//        this.template.convertAndSendToUser("username", "/user/private/messages", message);

        return new MessageResponseDto(message, LocalDateTime.now());
    }

}
