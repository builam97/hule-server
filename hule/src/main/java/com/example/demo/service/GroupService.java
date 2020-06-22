package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Group;

@Service
public interface GroupService {
    public Group selectGroupByUserId(Long userId);
}
