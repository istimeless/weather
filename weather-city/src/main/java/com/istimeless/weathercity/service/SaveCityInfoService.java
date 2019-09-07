package com.istimeless.weathercity.service;

import com.istimeless.weathercity.vo.CityResponse;

/**
 * @author lijiayin
 */
public interface SaveCityInfoService {

    /**
     * 保存城市信息到数据库
     * @param response
     */
    void saveCityInfo(CityResponse response);
}
