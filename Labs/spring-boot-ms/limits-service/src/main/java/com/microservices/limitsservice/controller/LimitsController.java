package com.microservices.limitsservice.controller;

import com.microservices.limitsservice.bean.Limits;
import com.microservices.limitsservice.configuration.Configuration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LimitsController {

    @Autowired
    private Configuration configuration;

    @Autowired
    private Environment env;

    @GetMapping("/limits")
    public Limits retrieveLimits() {
        log.info("inside limit controller.."+configuration.getMsg());
        return new Limits(configuration.getMinimum(),
                configuration.getMaximum());
    }
}
