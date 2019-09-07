package com.istimeless.weathercity.service.impl;

import com.istimeless.weathercity.advice.WeatherCityEnum;
import com.istimeless.weathercity.service.CacheCityService;
import com.istimeless.weathercity.service.CityInfoService;
import com.istimeless.weathercity.service.SaveCityInfoService;
import com.istimeless.weathercity.vo.CityRequest;
import com.istimeless.weathercity.vo.CityResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author lijiayin
 */
@Slf4j
@Service
public class CacheCityServiceImpl implements CacheCityService {
    
    private final CityInfoService cityInfoService;
    
    private final SaveCityInfoService saveCityInfoService;

    public CacheCityServiceImpl(CityInfoService cityInfoService, 
                                SaveCityInfoService saveCityInfoService) {
        this.cityInfoService = cityInfoService;
        this.saveCityInfoService = saveCityInfoService;
    }

    @Override
    public void cacheCity() {
        CityResponse cityResponse = cityInfoService.cityInfo(CityRequest.builder().subdistrict(3).build());
        if(WeatherCityEnum.SUCCESS.getCode().equals(cityResponse.getStatus())){
            saveCityInfoService.saveCityInfo(cityResponse);
        }
    }
}
