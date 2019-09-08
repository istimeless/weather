package com.istimeless.weathercity.service;

import com.istimeless.weathercity.advice.WeatherCityEnum;
import com.istimeless.weathercommon.vo.CityRequest;
import com.istimeless.weathercommon.vo.CityResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author lijiayin
 */
@Slf4j
@Service
public class CacheCityService {
    
    private final CityInfoService cityInfoService;
    
    private final SaveCityInfoService saveCityInfoService;

    public CacheCityService(CityInfoService cityInfoService,
                            SaveCityInfoService saveCityInfoService) {
        this.cityInfoService = cityInfoService;
        this.saveCityInfoService = saveCityInfoService;
    }
    
    public void cacheCity() {
        CityResponse cityResponse = cityInfoService.cityInfo(CityRequest.builder().subdistrict(3).build());
        if(WeatherCityEnum.SUCCESS.getCode().equals(cityResponse.getStatus())){
            saveCityInfoService.saveCityInfo(cityResponse);
        }
    }
}
