package com.istimeless.weatherweb.controller;

import com.istimeless.weathercityamapclient.client.WeatherCityClient;
import com.istimeless.weathercollectamapclient.client.WeatherCollectClient;
import com.istimeless.weathercollectamapclient.vo.WeatherResponse;
import com.istimeless.weathercommon.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijiayin
 */
@RestController
@RequestMapping("/test")
public class TestController {
    
    @Autowired
    private WeatherCityClient cityClient;
    
    @Autowired
    private WeatherCollectClient collectClient;
    
    @GetMapping("/city/{cityName}")
    public Result<WeatherResponse> test(@PathVariable("cityName") String cityName){
        return collectClient.live(cityClient
                .getCityCodeByCityName(cityName).getData().entrySet()
                .stream().findFirst().orElse(null)
                .getValue());
    }
}
