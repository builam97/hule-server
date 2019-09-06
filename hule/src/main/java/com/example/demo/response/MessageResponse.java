package com.example.demo.response;

import lombok.Data;

@Data
public class MessageResponse {
    private String message;

    private String userName;

    public MessageResponse(String message, String userName) {
        super();
        this.message = message;
        this.userName = userName;
    }
}
