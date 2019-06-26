package com.ls.weathercollectamapservice.service;

import com.ls.weathercollectamapservice.enums.WeatherTypeEnum;
import com.ls.weathercollectamapclient.vo.WeatherResponse;

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
}
