package com.istimeless.weathercity.service;


import com.istimeless.weathercity.vo.CityRequest;
import com.istimeless.weathercity.vo.CityResponse;

/**
 * @author lijiayin
 */
public interface CityInfoService {

    /**
     * 获取城市信息
     * @param request
     * @return
     */
    CityResponse cityInfo(CityRequest request);
}
