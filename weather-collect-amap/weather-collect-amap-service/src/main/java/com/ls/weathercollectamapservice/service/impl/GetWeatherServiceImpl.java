package com.ls.weathercollectamapservice.service.impl;

import com.ls.weathercollectamapclient.vo.WeatherResponse;
import com.ls.weathercollectamapservice.enums.WeatherTypeEnum;
import com.ls.weathercollectamapservice.service.GetWeatherService;
import com.ls.weathercommon.properties.WeatherProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


/**
 * @author lijiayin
 */
@Slf4j
@Service
public class GetWeatherServiceImpl implements GetWeatherService {
    
    private final RestTemplate restTemplateOut;
    
    private final WeatherProperties properties;

    @Autowired
    public GetWeatherServiceImpl(RestTemplate restTemplateOut, 
                                 WeatherProperties properties) {
        this.restTemplateOut = restTemplateOut;
        this.properties = properties;
    }

    @Override
    public WeatherResponse collectWeatherInfo(String city, WeatherTypeEnum type) {
        
        String url = properties.getAmap().getBasic().getUrl() + "extensions=" + type.getCode() 
                + "&city=" + city + "&key=" + properties.getAmap().getBasic().getKey();
        return restTemplateOut.getForObject(url, WeatherResponse.class);
    }
}
