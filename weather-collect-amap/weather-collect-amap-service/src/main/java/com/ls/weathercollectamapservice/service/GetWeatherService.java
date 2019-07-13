package com.ls.weathercollectamapservice.service;

import com.ls.weathercollectamapclient.vo.WeatherResponse;
import com.ls.weathercollectamapservice.enums.WeatherTypeEnum;

/**
 * @author lijiayin
 */
public interface GetWeatherService {

    /**
     * 查询天气信息
     * @param city
     * @param type
     * @return
     */
    WeatherResponse collectWeatherInfo(String city, WeatherTypeEnum type);
}
