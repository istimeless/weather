package com.ls.weathercityamapservice.controller;

import com.ls.weathercityamapclient.vo.CityRequest;
import com.ls.weathercityamapclient.vo.CityResponse;
import com.ls.weathercityamapservice.service.WeatherCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
        CityRequest request = new CityRequest();
        request.setKeywords(city);
        CityResponse cityResponse = weatherCityService.cityInfo(request);
        return cityResponse.getDistricts().get(0).getAdcode();
    }

    @PostMapping("/cityInfo")
    public CityResponse cityInfo(CityRequest request){
        return weatherCityService.cityInfo(request);
    }
}
