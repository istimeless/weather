package com.ls.weathercityamapservice.service;

import com.ls.weathercityamapclient.vo.CityRequest;
import com.ls.weathercityamapclient.vo.CityResponse;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author lijiayin
 */
public interface WeatherCityService {
    

    /**
     * 根据城市名称获取城市编码
     * @param cityName
     * @return
     */
    Map<String, String> getCityCodeByCityName(String cityName);

    /**
     * 获取城市编码-城市名称
     * @param request
     * @return
     */
    Map<Object, Object> cityCodeNameMap(CityRequest request);
}
