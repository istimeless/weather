package com.istimeless.weathercity.controller;

import com.istimeless.weathercommon.vo.WeatherCityVO;
import com.istimeless.weatherredis.utils.RedisUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lijiayin
 */
@RestController
public class CityInfoController {

    @GetMapping("/getCityInfo")
    public List<WeatherCityVO> getWeatherCityByCityName(@RequestParam String cityName) {
        return RedisUtil.getLikes(cityName);
    }
}
