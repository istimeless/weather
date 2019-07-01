package com.ls.weathercityamapservice.constant;

import com.ls.weathercityamapclient.vo.CityRequest;

/**
 * @author lijiayin
 */
public class WeatherConstant {
    
    public static final String CACHE_PREFIX = "weather:";
    
    public static final Integer CACHE_TIME = 24;
    
    public static final CityRequest ALL_CITY = CityRequest.builder().subdistrict(3).build();
}
