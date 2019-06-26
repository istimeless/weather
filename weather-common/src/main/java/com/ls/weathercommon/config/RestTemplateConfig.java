package com.ls.weathercommon.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author lijiayin
 */
@Configuration
public class RestTemplateConfig {
    
    private final RestTemplateBuilder builder;

    @Autowired
    public RestTemplateConfig(RestTemplateBuilder builder) {
        this.builder = builder;
    }

    @Bean(name = "restTemplate")
    @LoadBalanced
    public RestTemplate restTemplate(){
        return builder.build();
    }

    @Bean(name = "restTemplateOut")
    public RestTemplate restTemplateOut(){
        return builder.build();
    }
}
