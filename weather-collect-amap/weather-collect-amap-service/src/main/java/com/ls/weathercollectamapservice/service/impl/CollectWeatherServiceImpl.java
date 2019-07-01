package com.ls.weathercollectamapservice.service.impl;

import com.ls.weathercollectamapclient.vo.WeatherResponse;
import com.ls.weathercollectamapservice.constant.WeatherConstant;
import com.ls.weathercollectamapservice.enums.WeatherTypeEnum;
import com.ls.weathercollectamapservice.service.CollectWeatherService;
import com.ls.weathercommon.properties.WeatherProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author lijiayin
 */
@Slf4j
@Service
public class CollectWeatherServiceImpl implements CollectWeatherService {
    
    private final RestTemplate restTemplateOut;
    
    private final WeatherProperties properties;
    
    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public CollectWeatherServiceImpl(RestTemplate restTemplateOut, WeatherProperties properties, RedisTemplate<String, Object> redisTemplate) {
        this.restTemplateOut = restTemplateOut;
        this.properties = properties;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public WeatherResponse collectWeatherInfo(String city, WeatherTypeEnum type) {
        String key = WeatherConstant.CACHE_PREFIX + type.getCode() + ":" + city;
        WeatherResponse resp = (WeatherResponse)redisTemplate.opsForValue().get(key);
        if(resp != null){
            return resp;
        }
        String url = properties.getAmap().getBasic().getUrl() + "extensions=" + type.getCode() 
                + "&city=" + city + "&key=" + properties.getAmap().getBasic().getKey();
        WeatherResponse weatherResponse = restTemplateOut.getForObject(url, WeatherResponse.class);
        if(weatherResponse != null && weatherResponse.getCount() > 0){
            redisTemplate.opsForValue().set(key, weatherResponse, WeatherConstant.CACHE_TIME, TimeUnit.HOURS);
        }
        return weatherResponse;
    }

    @Override
    public void collectAllWeatherInfo(List<String> cityCode) {
        ExecutorService live = Executors.newFixedThreadPool(50);
        ExecutorService forecast = Executors.newFixedThreadPool(50);
        cityCode.forEach(city -> {
            live.execute(() -> collectWeatherInfo(city, WeatherTypeEnum.ALL));
            forecast.execute(() -> collectWeatherInfo(city, WeatherTypeEnum.BASE));
        });
        live.shutdown();
        forecast.shutdown();
    }
}
