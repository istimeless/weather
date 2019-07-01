package com.ls.weathercityamapservice.service;

import com.ls.weathercityamapclient.vo.CityRequest;
import com.ls.weathercityamapclient.vo.CityResponse;

import java.util.List;
import java.util.Map;

/**
 * @author lijiayin
 */
public interface WeatherCityService {

    /**
     * 获取城市信息
     * @param request
     * @return
     */
    CityResponse cityInfo(CityRequest request);

    /**
     * 获取城市编码
     * @param request
     * @return
     */
    List<String> cityCode(CityRequest request);

    /**
     * 获取城市名称-城市编码
     * @param request
     * @return
     */
    Map<Object, Object> cityMap(CityRequest request);

    /**
     * 根据城市名称获取城市编码
     * @param cityName
     * @return
     */
    String cityCode(String cityName);
}
