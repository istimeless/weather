package com.istimeless.weathercity.controller;

import com.istimeless.weathercity.advice.WeatherCityEnum;
import com.istimeless.weathercity.advice.WeatherCityException;
import com.istimeless.weathercity.client.RedisClient;
import com.istimeless.weathercity.entity.WeatherCity;
import com.istimeless.weathercommon.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lijiayin
 */
@RestController
public class CityInfoController {
    
    @Autowired
    private RedisClient redisClient;
    
    @GetMapping("/city/get/{cityName}")
    public List<WeatherCity> getWeatherCityByCityName(@PathVariable String cityName){
        Result<List<WeatherCity>> result = redisClient.getValues(cityName);
        if(result.getCode().equals(WeatherCityEnum.SUCCESS.getCode())){
            return result.getData();
        }
        throw new WeatherCityException(result.getCode(), result.getMsg());
    }
}
