package com.example.demo.response;

import lombok.Data;

@Data
public class LoginResponse {
    private String accessKey;

    public LoginResponse(String accessKey) {
        super();
        this.accessKey = accessKey;
    }
}
