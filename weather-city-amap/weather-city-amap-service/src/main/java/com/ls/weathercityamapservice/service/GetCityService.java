package com.ls.weathercityamapservice.service;

import com.ls.weathercityamapclient.vo.CityRequest;
import com.ls.weathercityamapclient.vo.CityResponse;

/**
 * @author lijiayin
 */
public interface GetCityService {

    /**
     * 获取城市信息
     * @param request
     * @return
     */
    CityResponse cityInfo(CityRequest request);
}
