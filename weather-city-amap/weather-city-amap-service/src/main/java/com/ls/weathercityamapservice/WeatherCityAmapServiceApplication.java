package com.ls.weathercityamapservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackages = "com.ls")
@ComponentScan(basePackages = "com.ls")
public class WeatherCityAmapServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherCityAmapServiceApplication.class, args);
    }

}
