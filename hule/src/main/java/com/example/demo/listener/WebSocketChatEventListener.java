package com.example.demo.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.example.demo.response.WebSocketChatMessage;

@Component
public class WebSocketChatEventListener {
    @Autowired
    private SimpMessageSendingOperations messagingTemplate;
    @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
        System.out.println("Received a new web socket connection");
    }
    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String username = (String) headerAccessor.getSessionAttributes().get("username");
        System.out.println("11111111111111111111111111111");
//        if(username != null) {
            System.out.println("11111111111111111111111111111 "+ username);
            WebSocketChatMessage chatMessage = new WebSocketChatMessage();
            chatMessage.setType("Leave");
            chatMessage.setSender(username);
            messagingTemplate.convertAndSend("/topic/public", "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
//        }
    }
}