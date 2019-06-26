package com.ls.weatherservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collections;

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
    
    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = builder.build();
//        restTemplate.setInterceptors(Collections.singletonList((httpRequest, bytes, clientHttpRequestExecution) -> {
//            HttpHeaders headers = httpRequest.getHeaders();
//            headers.add(HttpHeaders.USER_AGENT, 
//                    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36");
//            return clientHttpRequestExecution.execute(httpRequest, bytes);
//        }));
        restTemplate.setErrorHandler(new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
                return false;
            }

            @Override
            public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {

            }
        });
        return restTemplate;
    }
}
