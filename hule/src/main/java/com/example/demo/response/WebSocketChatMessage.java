package com.example.demo.response;

public class WebSocketChatMessage {
    private String type;
    private String sender;
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getSender() {
        return sender;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }
}
