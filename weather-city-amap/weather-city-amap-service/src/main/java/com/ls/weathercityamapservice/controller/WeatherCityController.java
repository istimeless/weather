package com.ls.weathercityamapservice.controller;

import com.ls.weathercityamapclient.vo.CityRequest;
import com.ls.weathercityamapclient.vo.CityResponse;
import com.ls.weathercityamapservice.constant.WeatherConstant;
import com.ls.weathercityamapservice.service.WeatherCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * @author lijiayin
 */
@RestController
@RequestMapping("/city")
public class WeatherCityController {
    
    private final WeatherCityService weatherCityService;

    @Autowired
    public WeatherCityController(WeatherCityService weatherCityService) {
        this.weatherCityService = weatherCityService;
    }

    @GetMapping("/cityCode/{city}")
    public String cityCode(@PathVariable("city") String city){
        return weatherCityService.cityCode(city);
    }

    @PostMapping("/cityInfo")
    public CityResponse cityInfo(CityRequest request){
        return weatherCityService.cityInfo(request);
    }

    
    @GetMapping("/cityCode")
    public List<String> allCityCode(){
        return weatherCityService.cityCode(WeatherConstant.ALL_CITY);
    }

    @GetMapping("/cityMap")
    public Map<Object, Object> cityMap(CityRequest request){
        return weatherCityService.cityMap(request);
    }
}
