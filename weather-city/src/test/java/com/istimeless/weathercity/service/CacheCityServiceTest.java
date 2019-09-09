package com.istimeless.weathercity.service;

import com.istimeless.weathercity.WeatherCityVOApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CacheCityServiceTest extends WeatherCityVOApplicationTests {

    @Autowired
    private CacheCityService cacheCityService;

    @Test
    public void cacheCity() {
        cacheCityService.cacheCity();
    }
}