package com.istimeless.weatherinfo.controller;

import com.istimeless.weatherinfo.service.CacheWeatherInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijiayin
 */
@Slf4j
@RestController
public class CacheWeatherInfoController {

    private final CacheWeatherInfoService cacheWeatherInfoService;

    public CacheWeatherInfoController(CacheWeatherInfoService cacheWeatherInfoService) {
        this.cacheWeatherInfoService = cacheWeatherInfoService;
    }

    @GetMapping("/cacheWeatherLive")
    public void cacheWeatherLive() {
        cacheWeatherInfoService.cacheWeatherLive();
    }

    @GetMapping("/cacheWeatherForecast")
    public void cacheWeatherForecast() {
        cacheWeatherInfoService.cacheWeatherForecast();
    }
}
