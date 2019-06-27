package com.ls.weathercollectamapclient.client;

import com.ls.weathercollectamapclient.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lijiayin
 */
@FeignClient(name = "weather-gateway", fallback = WeatherCollectClient.WeatherCollectClientFallBack.class)
public interface WeatherCollectClient {

    /**
     * 查询实时天气
     * @param city
     * @return
     */
    @GetMapping("/weather/collect/live/{city}")
    WeatherResponse live(@PathVariable("city") String city);

    /**
     * 查询天气预报
     * @param city
     * @return
     */
    @GetMapping("/weather/collect/forecast/{city}")
    WeatherResponse forecast(@PathVariable("city")String city);

    @Component
    class WeatherCollectClientFallBack implements WeatherCollectClient{
        @Override
        public WeatherResponse live(String city) {
            return null;
        }

        @Override
        public WeatherResponse forecast(String city) {
            return null;
        }
    }
}
