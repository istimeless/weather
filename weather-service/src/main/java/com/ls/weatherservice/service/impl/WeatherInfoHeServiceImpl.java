package com.ls.weatherservice.service.impl;

import com.ls.weatherservice.properties.WeatherProperties;
import com.ls.weatherservice.service.WeatherInfoService;
import com.ls.weatherservice.utils.HeWeatherUtil;
import com.ls.weatherservice.vo.WeatherResponse;
import com.ls.weatherservice.vo.heweather.HeWeather;
import com.ls.weatherservice.vo.heweather.HeWeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/**
 * @author lijiayin
 */
@Slf4j
@Service("weatherInfoHeService")
public class WeatherInfoHeServiceImpl implements WeatherInfoService<HeWeather> {
    
    private final RestTemplate restTemplate;
    
    private final WeatherProperties weatherProperties;

    @Autowired
    public WeatherInfoHeServiceImpl(RestTemplate restTemplate, WeatherProperties weatherProperties) {
        this.restTemplate = restTemplate;
        this.weatherProperties = weatherProperties;
    }

    @Override
    public WeatherResponse<HeWeather> collectionWeatherInfo(String location) throws Exception{
        String url = weatherProperties.getHeWeather().getUrl();
        HashMap<String, String> param = new HashMap<>(8);
        param.put("location", location);
        String sign = HeWeatherUtil.getSignature(param, weatherProperties.getHeWeather().getKey());
        url += "location=" + location + "&username=" + weatherProperties.getHeWeather().getUsername() 
                + "&t=" + (System.currentTimeMillis() / 1000) + "&sign=" + sign;
        log.info("天气请求url：{}", url);
        HeWeatherResponse weatherResponse = restTemplate.getForObject(url, HeWeatherResponse.class);
        Assert.notNull(weatherResponse, "获取天气信息失败");
        return WeatherResponse.<HeWeather>builder().result(weatherResponse.getHeHeWeather6()).build();
    }
}
