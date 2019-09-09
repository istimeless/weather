package com.istimeless.weatherinfo.service;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.istimeless.weathercommon.constant.CityConstant;
import com.istimeless.weathercommon.enums.WeatherTypeEnum;
import com.istimeless.weathercommon.vo.Forecast;
import com.istimeless.weathercommon.vo.Live;
import com.istimeless.weathercommon.vo.WeatherResponse;
import com.istimeless.weatherredis.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author lijiayin
 */
@Slf4j
@Service
public class CacheWeatherInfoService {
    
    private final WeatherInfoService weatherInfoService;
    
    private final SaveWeatherInfoService saveWeatherInfoService;

    public CacheWeatherInfoService(WeatherInfoService weatherInfoService, 
                                   SaveWeatherInfoService saveWeatherInfoService) {
        this.weatherInfoService = weatherInfoService;
        this.saveWeatherInfoService = saveWeatherInfoService;
    }

    public void cacheWeatherLive(){
        log.info("开始缓存实时天气信息：{}", System.currentTimeMillis());
        List<Future<WeatherResponse>> futureList = weatherInfo(WeatherTypeEnum.BASE);
        
        List<Live> lives = new ArrayList<>();
        futureList.forEach(future -> {
            try {
                lives.addAll(future.get().getLives());
            } catch (Exception e) {
                log.error("获取实时天气信息失败：{}", e.getMessage(), e);
            } 
        });
        
        saveWeatherInfoService.saveWeatherLive(lives);
        log.info("结束缓存实时天气信息：{}", System.currentTimeMillis());
    }

    public void cacheWeatherForecast(){
        log.info("开始缓存天气预报信息：{}", System.currentTimeMillis());
        List<Future<WeatherResponse>> futureList = weatherInfo(WeatherTypeEnum.ALL);

        List<Forecast> forecasts = new ArrayList<>();
        futureList.forEach(future -> {
            try {
                forecasts.addAll(future.get().getForecasts());
            } catch (Exception e) {
                log.error("获取天气预报信息失败：{}", e.getMessage(), e);
            }
        });

        saveWeatherInfoService.saveWeatherForecast(forecasts);
        log.info("结束缓存天气预报信息：{}", System.currentTimeMillis());
    }

    /**
     * 多线程并发获取天气信息
     * @param weatherTypeEnum
     * @return
     */
    private List<Future<WeatherResponse>> weatherInfo(WeatherTypeEnum weatherTypeEnum){
        List<String> cityList = RedisUtil.get(CityConstant.CITY_LIST);
        ThreadFactoryBuilder factoryBuilder = new ThreadFactoryBuilder();
        factoryBuilder.setNameFormat("weather-info");
        ThreadFactory threadFactory = factoryBuilder.build();
        LinkedBlockingDeque<Runnable> blockingDeque = new LinkedBlockingDeque<>();
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(100, 100, 0, TimeUnit.SECONDS,
                        blockingDeque, threadFactory, new ThreadPoolExecutor.AbortPolicy());

        List<Future<WeatherResponse>> futureList = new ArrayList<>();
        cityList.forEach(city ->
                futureList.add(threadPoolExecutor.submit(() ->
                        weatherInfoService.weatherInfo(city, weatherTypeEnum)))
        );
        threadPoolExecutor.shutdown();
        
        return futureList;
    }
}
