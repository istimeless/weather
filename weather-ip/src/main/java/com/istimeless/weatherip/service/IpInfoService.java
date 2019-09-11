package com.istimeless.weatherip.service;

import com.istimeless.weathercommon.vo.IpResponse;
import com.istimeless.weatherip.properties.WeatherIpProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author lijiayin
 */
@Slf4j
@Service
public class IpInfoService {
    
    private final WeatherIpProperties properties;
    
    private final RestTemplate restTemplate;

    public IpInfoService(WeatherIpProperties properties, 
                         RestTemplate restTemplate) {
        this.properties = properties;
        this.restTemplate = restTemplate;
    }
    
    public IpResponse ipInfo(String ip){
        String url = properties.getUrl() + "key=" + properties.getKey() + "&ip=" + ip;
        log.info("请求IP信息url：{}", url);
        IpResponse result = restTemplate.getForObject(url, IpResponse.class);
        log.info("请求IP信息返回：{}", result);
        return result;
    }
}
