package com.ls.weathercollectamapservice.controller;

import com.ls.weathercityamapclient.client.WeatherCityClient;
import com.ls.weathercollectamapservice.enums.WeatherTypeEnum;
import com.ls.weathercollectamapservice.service.CollectWeatherService;
import com.ls.weathercollectamapclient.vo.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lijiayin
 */
@Slf4j
@RestController
@RequestMapping("/collect")
public class CollectWeatherController {
    
    private final CollectWeatherService collectWeatherService;
    
    private final WeatherCityClient weatherCityClient;

    @Autowired
    public CollectWeatherController(CollectWeatherService collectWeatherService, WeatherCityClient weatherCityClient) {
        this.collectWeatherService = collectWeatherService;
        this.weatherCityClient = weatherCityClient;
    }

    @GetMapping("/live/{city}")
    public WeatherResponse live(@PathVariable("city") String city){
        String cityCode = weatherCityClient.cityCode(city);
        return collectWeatherService.collectWeatherInfo(cityCode, WeatherTypeEnum.BASE);
    }

    @GetMapping("/forecast/{city}")
    public WeatherResponse forecast(@PathVariable("city")String city){
        String cityCode = weatherCityClient.cityCode(city);
        return collectWeatherService.collectWeatherInfo(cityCode, WeatherTypeEnum.ALL);
    }

    @GetMapping("/all")
    public void loadAll(){
        List<String> cityCode = weatherCityClient.allCityCode();
        collectWeatherService.collectAllWeatherInfo(cityCode);
    }
}
