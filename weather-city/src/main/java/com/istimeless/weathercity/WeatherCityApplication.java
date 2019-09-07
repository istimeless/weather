package com.istimeless.weathercity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class WeatherCityApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherCityApplication.class, args);
    }

}
