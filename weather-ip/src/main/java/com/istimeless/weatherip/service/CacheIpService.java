package com.istimeless.weatherip.service;

import com.istimeless.weathercommon.vo.IpResponse;
import com.istimeless.weatherip.entity.WeatherIp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author lijiayin
 */
@Slf4j
@Service
public class CacheIpService {
    
    private final IpInfoService ipInfoService;
    
    private final SaveIpInfoService saveIpInfoService;

    public CacheIpService(IpInfoService ipInfoService, 
                          SaveIpInfoService saveIpInfoService) {
        this.ipInfoService = ipInfoService;
        this.saveIpInfoService = saveIpInfoService;
    }

    public WeatherIp cacheIpInfo(String ip){
        IpResponse response = ipInfoService.ipInfo(ip);
        
        WeatherIp weatherIp = new WeatherIp();
        BeanUtils.copyProperties(response, weatherIp);
        Date now = new Date();
        weatherIp.setCreateTime(now);
        weatherIp.setUpdateTime(now);
        weatherIp.setIp(ip);
        
        saveIpInfoService.saveIpInfo(weatherIp);
        return weatherIp;
    }
}
