package com.ls.weatherservice.service.impl;

import com.ls.weatherservice.constants.Constant;
import com.ls.weatherservice.properties.WeatherProperties;
import com.ls.weatherservice.service.WeatherInfoService;
import com.ls.weatherservice.utils.SenWeatherUtil;
import com.ls.weatherservice.vo.WeatherResponse;
import com.ls.weatherservice.vo.seniverse.SenResult;
import com.ls.weatherservice.vo.seniverse.SenWeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.security.SignatureException;
import java.util.concurrent.TimeUnit;

/**
 * @author lijiayin
 */
@Slf4j
@Service("weatherInfoSenService")
public class WeatherInfoSenServiceImpl implements WeatherInfoService<SenResult> {
    
    private final WeatherProperties properties;
    
    private final RestTemplate restTemplate;
    
    private final RedisTemplate<String, Object> redisTemplate;
    

    @Autowired
    public WeatherInfoSenServiceImpl(WeatherProperties properties, RestTemplate restTemplate,
                                     RedisTemplate<String, Object> redisTemplate) {
        this.properties = properties;
        this.restTemplate = restTemplate;
        this.redisTemplate = redisTemplate;
    }

    @Override
    @SuppressWarnings("all")
    public WeatherResponse<SenResult> collectionWeatherInfo(String location) throws Exception{
        String url = generateGetDiaryWeatherURL(location,
                "zh-Hans",
                "c",
                "1",
                "1");
        log.debug("请求天气信息url: {}", url);
        String key = Constant.WeatherInfo.CACHE_PREFIX + Constant.WeatherInfo.WeatherNow.CACHE_PREFIX + location;
        WeatherResponse<SenResult> resp = (WeatherResponse<SenResult>)redisTemplate.opsForValue().get(key);
        if(resp != null){
            return resp;
        }
        URI uri = new URI(url);
        SenWeatherResponse senWeatherResponse = restTemplate.getForObject(uri, SenWeatherResponse.class);
        Assert.notNull(senWeatherResponse, "获取天气信息失败");
        Assert.isNull(senWeatherResponse.getStatus(), 
                "获取天气信息失败" + senWeatherResponse.getStatus() + ":" + senWeatherResponse.getStatusCode());
        WeatherResponse<SenResult> weatherResponse = WeatherResponse.<SenResult>builder()
                .result(senWeatherResponse.getResults()).build();
        redisTemplate.opsForValue().set(key, weatherResponse, 
                Constant.WeatherInfo.WeatherNow.CACHE_TIME, TimeUnit.MINUTES);
        return weatherResponse;
    }

    /**
     * Generate the URL to get diary weather
     * @param location
     * @param language
     * @param unit
     * @param start
     * @param days
     * @return
     */
    private String generateGetDiaryWeatherURL(
            String location,
            String language,
            String unit,
            String start,
            String days
    )  throws SignatureException, UnsupportedEncodingException {
        String timestamp = String.valueOf(System.currentTimeMillis());
        String params = "ts=" + timestamp + "&ttl=1800&uid=" + properties.getSenWeather().getPublicKey();
        String signature = URLEncoder.encode(
                SenWeatherUtil.generateSignature(params, properties.getSenWeather().getPrivateKey()), "UTF-8");
        return properties.getSenWeather().getUrl() + "now.json" + "?" + params 
                + "&sig=" + signature + "&location=" + location + "&language=" + language 
                + "&unit=" + unit + "&start=" + start + "&days=" + days;
    }
}
