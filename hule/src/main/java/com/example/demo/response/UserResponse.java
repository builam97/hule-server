package com.example.demo.response;

import com.example.demo.entities.Users;

import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    
    private String email;
    
    private String userName;

    public UserResponse(Users user) {
        super();
        this.id = user.getId();
        this.email = user.getEmail();
        this.userName = user.getUserName();
    }
}
