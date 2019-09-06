package com.example.demo.controller;

import org.springframework.stereotype.Controller;

import com.example.demo.response.MessageResponse;
import com.example.demo.service.UserService;
import com.example.demo.utils.SecurityUtil;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;

import java.util.Map;

@Controller
public class WebSocketController {
    @Autowired
    private SimpMessageSendingOperations messagingTemplate;
    
    @Autowired
    private UserService userService;

    @MessageMapping("/message/{groupId}")
    @SendTo("/topic/reply/{groupId}")
    public MessageResponse processMessageFromClient(@DestinationVariable Long groupId, @Payload String message) throws Exception {
        System.out.println("group: .............................. " + groupId);
        String name = new Gson().fromJson(message, Map.class).get("name").toString();
        String token = new Gson().fromJson(message, Map.class).get("token").toString();
        System.out.println("token: " + token);
        String userName = userService.getUserName(token);
        MessageResponse messageResponse = new MessageResponse(name, userName);
        return messageResponse;
    }
    
//    @MessageExceptionHandler
//    public String handleException(Throwable exception) {
//        messagingTemplate.convertAndSend("/errors", exception.getMessage());
//        return exception.getMessage();
//    }
}
