package com.istimeless.weatherip.service;

import com.istimeless.weathercommon.constant.IpConstant;
import com.istimeless.weatherip.entity.WeatherIp;
import com.istimeless.weatherip.repository.WeatherIpRepository;
import com.istimeless.weatherredis.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lijiayin
 */
@Slf4j
@Service
public class SaveIpInfoService {
    
    private final IpInfoService ipInfoService;
    
    private final WeatherIpRepository repository;

    public SaveIpInfoService(IpInfoService ipInfoService, 
                             WeatherIpRepository repository) {
        this.ipInfoService = ipInfoService;
        this.repository = repository;
    }


    @Transactional(rollbackFor = Exception.class)
    public void saveIpInfo(WeatherIp weatherIp){
        RedisUtil.set(IpConstant.IP_INFO_PREFIX + weatherIp.getIp(), weatherIp);
        repository.save(weatherIp);
    }
}
