package com.ls.weathercityamapservice.controller;

import com.ls.weathercityamapclient.vo.CityRequest;
import com.ls.weathercityamapclient.vo.CityResponse;
import com.ls.weathercityamapservice.constant.WeatherConstant;
import com.ls.weathercityamapservice.service.WeatherCityService;
import com.ls.weathercommon.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * @author lijiayin
 */
@RestController
@RequestMapping("/city")
public class WeatherCityController {
    
    private final WeatherCityService weatherCityService;

    @Autowired
    public WeatherCityController(WeatherCityService weatherCityService) {
        this.weatherCityService = weatherCityService;
    }

    /**
     * 根据城市名称获取城市编码
     * @param cityName
     * @return
     */
    @GetMapping("/cityCode/{cityName}")
    public Result<Map<String, String>> cityNameCodeMap(@PathVariable("cityName") String cityName){
        return Result.success(weatherCityService.getCityCodeByCityName(cityName));
    }

    /**
     * 根据城市编码，获取当前城市的下一级城市
     * @param cityCode
     * @return
     */
    @GetMapping("/cityCodeNameMap/{cityCode}")
    public Result<Map<Object, Object>> cityCodeNameMap(@PathVariable(value = "cityCode", required = false) String cityCode){
        return Result.success(weatherCityService.cityCodeNameMap(CityRequest.builder()
                .subdistrict(1)
                .keywords(cityCode)
                .build()));
    }
}
