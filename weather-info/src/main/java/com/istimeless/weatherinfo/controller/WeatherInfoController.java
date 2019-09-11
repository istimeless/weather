package com.istimeless.weatherinfo.controller;

import com.istimeless.weathercommon.constant.WeatherInfoConstant;
import com.istimeless.weathercommon.vo.Forecast;
import com.istimeless.weatherinfo.aspect.IpToAdcode;
import com.istimeless.weatherinfo.entity.WeatherLive;
import com.istimeless.weatherredis.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijiayin
 */
@Slf4j
@RestController
public class WeatherInfoController {

    @IpToAdcode
    @GetMapping("/weatherLive")
    public WeatherLive weatherLive(@RequestParam(required = false) String adcode) {
        return RedisUtil.get(WeatherInfoConstant.WEATHER_LIVE_PREFIX + adcode);
    }

    @IpToAdcode
    @GetMapping("/weatherForecast")
    public Forecast weatherForecast(@RequestParam(required = false) String adcode) {
        return RedisUtil.get(WeatherInfoConstant.WEATHER_FORECAST_PREFIX + adcode);
    }
}
