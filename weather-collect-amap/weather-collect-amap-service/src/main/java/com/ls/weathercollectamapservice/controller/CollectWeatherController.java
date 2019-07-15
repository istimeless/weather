package com.ls.weathercollectamapservice.controller;

import com.ls.weathercityamapclient.client.WeatherCityClient;
import com.ls.weathercollectamapservice.enums.WeatherTypeEnum;
import com.ls.weathercollectamapservice.service.CollectWeatherService;
import com.ls.weathercollectamapclient.vo.WeatherResponse;
import com.ls.weathercommon.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijiayin
 */
@Slf4j
@RestController
@RequestMapping("/weather")
public class CollectWeatherController {
    
    private final CollectWeatherService collectWeatherService;

    @Autowired
    public CollectWeatherController(CollectWeatherService collectWeatherService) {
        this.collectWeatherService = collectWeatherService;
    }

    @GetMapping("/live/{city}")
    public Result<WeatherResponse> live(@PathVariable("city") String city){
        return Result.success(collectWeatherService.collectWeatherInfo(city, WeatherTypeEnum.BASE));
    }

    @GetMapping("/forecast/{city}")
    public Result<WeatherResponse> forecast(@PathVariable("city")String city){
        return Result.success(collectWeatherService.collectWeatherInfo(city, WeatherTypeEnum.ALL));
    }
}
