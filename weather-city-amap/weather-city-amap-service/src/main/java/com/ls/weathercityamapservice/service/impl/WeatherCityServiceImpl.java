package com.ls.weathercityamapservice.service.impl;

import com.ls.weathercityamapclient.vo.CityRequest;
import com.ls.weathercityamapclient.vo.CityResponse;
import com.ls.weathercityamapservice.constant.WeatherConstant;
import com.ls.weathercityamapservice.service.WeatherCityService;
import com.ls.weathercommon.properties.WeatherProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author lijiayin
 */
@Slf4j
@Service
public class WeatherCityServiceImpl implements WeatherCityService {
    
    private final WeatherProperties properties;
    
    private final RestTemplate restTemplateOut;
    
    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public WeatherCityServiceImpl(WeatherProperties properties, RestTemplate restTemplateOut, 
                                  RedisTemplate<String, Object> redisTemplate) {
        this.properties = properties;
        this.restTemplateOut = restTemplateOut;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public CityResponse cityInfo(CityRequest request) {
        String key = WeatherConstant.CACHE_PREFIX + "city:" + request.hashCode();
        CityResponse resp = (CityResponse)redisTemplate.opsForValue().get(key);
        if(resp != null){
            return resp;
        }
        String url = getRequestUrl(request);
        CityResponse cityResponse = restTemplateOut.getForObject(url, CityResponse.class);
        if(cityResponse != null){
            redisTemplate.opsForValue().set(key, cityResponse, WeatherConstant.CACHE_TIME, TimeUnit.HOURS);
        }
        return cityResponse;
    }
    
    private String getRequestUrl(CityRequest request){
        StringBuilder url = new StringBuilder();
        url.append(properties.getAmap().getCity().getUrl());
        url.append("key=");
        url.append(properties.getAmap().getCity().getKey());
        if(StringUtils.isNotBlank(request.getKeywords())){
            url.append("&keywords=");
            url.append(request.getKeywords());
        }
        if(request.getSubdistrict() != null){
            url.append("&subdistrict=");
            url.append(request.getSubdistrict());
        }
        if(request.getPage() != null){
            url.append("&page=");
            url.append(request.getPage());
        }
        if(request.getOffset() != null){
            url.append("&offset=");
            url.append(request.getOffset());
        }
        if(StringUtils.isNotBlank(request.getExtensions())){
            url.append("&extensions=");
            url.append(request.getExtensions());
        }
        if(StringUtils.isNotBlank(request.getFilter())){
            url.append("&filter=");
            url.append(request.getFilter());
        }
        if(StringUtils.isNotBlank(request.getCallback())){
            url.append("&callback=");
            url.append(request.getCallback());
        }
        if(StringUtils.isNotBlank(request.getOutput())){
            url.append("&output=");
            url.append(request.getOutput());
        }
        return url.toString();
    }
}
