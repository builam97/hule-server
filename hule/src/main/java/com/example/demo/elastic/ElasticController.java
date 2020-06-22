package com.example.demo.elastic;

import java.util.Map;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ElasticController {
    @Autowired
    Client client;
    @GetMapping("/view/{id}")
    public Map<String, Object> view(@PathVariable final String id) {
        GetResponse getResponse = client.prepareGet("builam", "dev", id).get();
        return getResponse.getSource();
    }
}
