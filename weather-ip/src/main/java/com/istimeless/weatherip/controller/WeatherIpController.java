package com.istimeless.weatherip.controller;

import com.istimeless.weathercommon.constant.IpConstant;
import com.istimeless.weathercommon.vo.WeatherIpVO;
import com.istimeless.weatherip.entity.WeatherIp;
import com.istimeless.weatherip.service.CacheIpService;
import com.istimeless.weatherredis.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author lijiayin
 */
@Slf4j
@RestController
public class WeatherIpController {
    
    @Autowired
    private CacheIpService cacheIpService;
    
    @GetMapping("/ip")
    public WeatherIpVO ipInfo(@RequestParam String ip){
        WeatherIp weatherIp;
        Object result = RedisUtil.get(IpConstant.IP_INFO_PREFIX + ip);
        if(Objects.isNull(result)){
            weatherIp = cacheIpService.cacheIpInfo(ip);
        }else {
            weatherIp = (WeatherIp) result;
        }
        WeatherIpVO weatherIpVO = new WeatherIpVO();
        BeanUtils.copyProperties(weatherIp, weatherIpVO);
        return weatherIpVO;
    }
}
