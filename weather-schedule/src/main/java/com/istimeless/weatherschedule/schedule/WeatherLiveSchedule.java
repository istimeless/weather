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
public class WeatherLiveSchedule {

    private final WeatherInfoClient client;

    public WeatherLiveSchedule(WeatherInfoClient client) {
        this.client = client;
    }

    @Scheduled(cron = "0 0/30 0/1 * * ?")
    public void cache() {
        log.info("开始缓存实时天气信息：{}", System.currentTimeMillis());
        Result result = client.cacheWeatherLive();
        log.info("结束缓存实时天气信息：{}", System.currentTimeMillis());
        log.info("缓存实时天气信息：{}", result);
    }
}
