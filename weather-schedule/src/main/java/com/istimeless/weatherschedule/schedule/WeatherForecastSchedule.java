package com.istimeless.weatherschedule.schedule;

import com.istimeless.weathercommon.vo.Result;
import com.istimeless.weatherschedule.client.WeatherInfoClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author lijiayin
 */
@Slf4j
@Component
public class WeatherForecastSchedule {
    
    private final WeatherInfoClient client;
    
    public WeatherForecastSchedule(WeatherInfoClient client) {
        this.client = client;
    }
    
    @Scheduled(cron = "0 0 9,12,19 * * ?")
    public void cache(){
        Result result = client.cacheWeatherForecast();
        log.info("缓存天气预报信息：{}", result);
    }
}
