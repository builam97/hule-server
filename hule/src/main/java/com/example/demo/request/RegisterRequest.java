package com.example.demo.request;

import com.example.demo.entities.Role;

import java.util.HashSet;
import java.util.Set;

public class RegisterRequest {

    private String email;

    private String userName;

    private String password;

    private int enabled;

    private String tokenKey;

    private Set<Role> roles = new HashSet<Role>();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getTokenKey() {
        return tokenKey;
    }

    public void setTokenKey(String tokenKey) {
        this.tokenKey = tokenKey;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public RegisterRequest(String email, String userName, String password, int enabled, String tokenKey, Set<Role> roles) {
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.enabled = enabled;
        this.tokenKey = tokenKey;
        this.roles = roles;
    }

    public RegisterRequest() {
    }
}
