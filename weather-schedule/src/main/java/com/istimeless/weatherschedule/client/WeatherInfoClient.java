package com.istimeless.weatherschedule.client;

import com.istimeless.weathercommon.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author lijiayin
 */
@FeignClient(name = "weather-info")
public interface WeatherInfoClient {

    @GetMapping("/cacheWeatherLive")
    Result cacheWeatherLive();

    @GetMapping("/cacheWeatherForecast")
    Result cacheWeatherForecast();
}
