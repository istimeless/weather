package com.ls.weatherservice.controller;

import com.ls.weatherservice.service.WeatherInfoService;
import com.ls.weatherservice.vo.WeatherResponse;
import com.ls.weatherservice.vo.heweather.HeWeather;
import com.ls.weatherservice.vo.seniverse.SenResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijiayin
 */
@RestController
@RequestMapping("/weather")
public class CollectionWeatherController {
    
    private final WeatherInfoService weatherInfoHeService;
    
    private final WeatherInfoService weatherInfoSenService;

    @Autowired
    public CollectionWeatherController(WeatherInfoService weatherInfoHeService, 
                                       WeatherInfoService weatherInfoSenService) {
        this.weatherInfoHeService = weatherInfoHeService;
        this.weatherInfoSenService = weatherInfoSenService;
    }

    @GetMapping("/he/info/{location}")
    @SuppressWarnings("all")
    public WeatherResponse<HeWeather> collectionHeWeatherInfo(@PathVariable("location") String location) throws Exception {
       return weatherInfoHeService.collectionWeatherInfo(location);
    }

    @GetMapping("/sen/info/{location}")
    @SuppressWarnings("all")
    public WeatherResponse<SenResult> collectionSenWeatherInfo(@PathVariable("location") String location) throws Exception{
        return weatherInfoSenService.collectionWeatherInfo(location);
    }
}
