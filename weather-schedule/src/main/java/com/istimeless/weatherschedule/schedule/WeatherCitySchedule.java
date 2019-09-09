package com.istimeless.weatherschedule.schedule;

import com.istimeless.weathercommon.vo.Result;
import com.istimeless.weatherschedule.client.WeatherCityClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author lijiayin
 */
@Slf4j
@Component
public class WeatherCitySchedule {

    private final WeatherCityClient client;

    public WeatherCitySchedule(WeatherCityClient client) {
        this.client = client;
    }

    @Scheduled(cron = "0 0 3 ? * TUE")
    public void cache() {
        log.info("开始缓存城市信息：{}", System.currentTimeMillis());
        Result result = client.cacheCity();
        log.info("结束缓存城市信息：{}", System.currentTimeMillis());
        log.info("缓存城市信息：{}", result);
    }
}
