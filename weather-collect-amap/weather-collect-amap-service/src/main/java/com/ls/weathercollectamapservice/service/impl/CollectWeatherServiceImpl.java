package com.ls.weathercollectamapservice.service.impl;

import com.ls.weathercollectamapclient.vo.WeatherResponse;
import com.ls.weathercollectamapservice.constant.WeatherConstant;
import com.ls.weathercollectamapservice.enums.WeatherTypeEnum;
import com.ls.weathercollectamapservice.service.CollectWeatherService;
import com.ls.weathercollectamapservice.service.GetWeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import java.util.concurrent.TimeUnit;

/**
 * @author lijiayin
 */
@Slf4j
@Service
public class CollectWeatherServiceImpl implements CollectWeatherService {
    
    private final GetWeatherService getWeatherService;
    
    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public CollectWeatherServiceImpl(RedisTemplate<String, Object> redisTemplate, 
                                     GetWeatherService getWeatherService) {
        this.redisTemplate = redisTemplate;
        this.getWeatherService = getWeatherService;
    }

    @Override
    public WeatherResponse collectWeatherInfo(String city, WeatherTypeEnum type) {
        String key = WeatherConstant.CACHE_PREFIX + type.getKey() + ":" + city;
        WeatherResponse resp = (WeatherResponse)redisTemplate.opsForValue().get(key);
        if(resp != null){
            return resp;
        }
        WeatherResponse weatherResponse = getWeatherService.collectWeatherInfo(city, type);
        if(weatherResponse != null && weatherResponse.getCount() > 0){
            redisTemplate.opsForValue().set(key, weatherResponse, WeatherConstant.CACHE_TIME, TimeUnit.HOURS);
        }
        return weatherResponse;
    }
}
