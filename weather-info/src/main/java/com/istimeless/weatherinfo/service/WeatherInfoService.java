package com.istimeless.weatherinfo.service;

import com.istimeless.weathercommon.enums.WeatherTypeEnum;
import com.istimeless.weathercommon.vo.WeatherResponse;
import com.istimeless.weatherinfo.properties.WeatherInfoProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author lijiayin
 */
@Slf4j
@Service
public class WeatherInfoService {
    
    private final WeatherInfoProperties properties;
    
    private final RestTemplate restTemplate;

    public WeatherInfoService(WeatherInfoProperties properties, 
                              RestTemplate restTemplate) {
        this.properties = properties;
        this.restTemplate = restTemplate;
    }

    public WeatherResponse weatherInfo(String city, WeatherTypeEnum type) {
        String url = properties.getUrl() + "extensions=" + type.getCode()
                + "&city=" + city + "&key=" + properties.getKey();
        log.info("请求天气信息url：{}", url);
        WeatherResponse result = restTemplate.getForObject(url, WeatherResponse.class);
        log.info("请求天气信息返回：{}", result);
        return result;
    }
}
