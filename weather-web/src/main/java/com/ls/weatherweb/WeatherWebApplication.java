package com.ls.weatherweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringCloudApplication
@EnableFeignClients(basePackages = "com.ls")
@ComponentScan(basePackages = "com.ls")
public class WeatherWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherWebApplication.class, args);
    }

}
