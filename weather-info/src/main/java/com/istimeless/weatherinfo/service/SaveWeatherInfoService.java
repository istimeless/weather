package com.istimeless.weatherinfo.service;

import com.istimeless.weathercommon.constant.WeatherInfoConstant;
import com.istimeless.weathercommon.vo.Forecast;
import com.istimeless.weathercommon.vo.Live;
import com.istimeless.weatherinfo.entity.WeatherLive;
import com.istimeless.weatherinfo.repository.WeatherLiveRepository;
import com.istimeless.weatherredis.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author lijiayin
 */
@Slf4j
@Service
public class SaveWeatherInfoService {

    private final WeatherLiveRepository weatherLiveRepository;

    public SaveWeatherInfoService(WeatherLiveRepository weatherLiveRepository) {
        this.weatherLiveRepository = weatherLiveRepository;
    }

    public void saveWeatherLive(List<Live> lives) {
        List<WeatherLive> weatherLives = new ArrayList<>();
        Map<String, WeatherLive> liveMap = new HashMap<>(5100);
        lives.forEach(live -> {
            Date now = new Date();
            WeatherLive weatherLive = new WeatherLive();
            BeanUtils.copyProperties(live, weatherLive);
            weatherLive.setId(live.getAdcode() + live.getReporttime());
            weatherLive.setCreateTime(now);
            weatherLive.setUpdateTime(now);
            weatherLives.add(weatherLive);
            liveMap.put(WeatherInfoConstant.WEATHER_LIVE_PREFIX + weatherLive.getAdcode(), weatherLive);
        });
        RedisUtil.set(liveMap);
        weatherLiveRepository.saveAll(weatherLives);
    }

    public void saveWeatherForecast(List<Forecast> forecasts) {
        Map<String, Forecast> forecastMap = new HashMap<>(5100);
        forecasts.forEach(forecast ->
                forecastMap.put(WeatherInfoConstant.WEATHER_FORECAST_PREFIX + forecast.getAdcode(), forecast)
        );
        RedisUtil.set(forecastMap);
    }
}
