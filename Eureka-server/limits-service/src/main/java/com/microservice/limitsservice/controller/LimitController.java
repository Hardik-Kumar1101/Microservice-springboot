package com.microservice.limitsservice.controller;

import com.microservice.limitsservice.configuration.Configuration;
import com.microservice.limitsservice.dto.Limits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitController {
    private final Configuration configuration;
    @Autowired
    public LimitController(Configuration configuration) {
        this.configuration = configuration;
    }

    @GetMapping("/limits")
    public Limits retriveLimits(){
        return new Limits(configuration.getMinimum(), configuration.getMaximum());
    }
}
