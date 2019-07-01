package com.ls.weathercollectamapservice.service;

import com.ls.weathercollectamapservice.enums.WeatherTypeEnum;
import com.ls.weathercollectamapclient.vo.WeatherResponse;

import java.util.List;

/**
 * @author lijiayin
 */
public interface CollectWeatherService {

    /**
     * 查询天气信息
     * @param city
     * @param type
     * @return
     */
    WeatherResponse collectWeatherInfo(String city, WeatherTypeEnum type);

    /**
     * 查询全国全部城市天气信息
     * @param cityCode
     */
    void collectAllWeatherInfo(List<String> cityCode);
}
