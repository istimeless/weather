package com.istimeless.weathercity.service;

import com.istimeless.weathercity.WeatherCityApplicationTests;
import com.istimeless.weathercity.service.CacheCityService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CacheCityServiceTest extends WeatherCityApplicationTests {

    @Autowired
    private CacheCityService cacheCityService;
    
    @Test
    public void cacheCity() {
        cacheCityService.cacheCity();
    }
}