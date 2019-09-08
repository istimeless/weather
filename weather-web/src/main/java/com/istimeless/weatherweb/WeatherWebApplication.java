package com.istimeless.weatherweb;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringCloudApplication
@EnableFeignClients(basePackages = "com.istimeless")
@ComponentScan(basePackages = "com.istimeless")
public class WeatherWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherWebApplication.class, args);
    }

}
