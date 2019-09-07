package com.istimeless.weathercity.service.impl;

import com.istimeless.weathercity.WeatherCityApplicationTests;
import com.istimeless.weathercity.service.CacheCityService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class CacheCityServiceImplTest extends WeatherCityApplicationTests {

    @Autowired
    private CacheCityService cacheCityService;
    
    @Test
    public void cacheCity() {
        cacheCityService.cacheCity();
    }
}