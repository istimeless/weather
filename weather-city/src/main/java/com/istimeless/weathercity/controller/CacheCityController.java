package com.istimeless.weathercity.controller;

import com.istimeless.weathercity.service.CacheCityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijiayin
 */
@Slf4j
@RestController
public class CacheCityController {
    
    @Autowired
    private CacheCityService cacheCityService;
    
    @GetMapping("/city/cacheCity")
    public void cacheCity(){
        cacheCityService.cacheCity();
    }
}
