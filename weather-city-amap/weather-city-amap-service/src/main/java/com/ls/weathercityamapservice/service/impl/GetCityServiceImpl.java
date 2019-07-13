package com.ls.weathercityamapservice.service.impl;

import com.ls.weathercityamapclient.vo.CityRequest;
import com.ls.weathercityamapclient.vo.CityResponse;
import com.ls.weathercityamapservice.service.GetCityService;
import com.ls.weathercommon.properties.WeatherProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author lijiayin
 */
@Slf4j
@Service
public class GetCityServiceImpl implements GetCityService {
    
    private final WeatherProperties properties;

    private final RestTemplate restTemplateOut;

    @Autowired
    public GetCityServiceImpl(WeatherProperties properties, RestTemplate restTemplateOut) {
        this.properties = properties;
        this.restTemplateOut = restTemplateOut;
    }

    @Override
    public CityResponse cityInfo(CityRequest request) {
        String url = getRequestUrl(request);
        log.info("请求城市信息url：{}", url);
        CityResponse cityResponse = restTemplateOut.getForObject(url, CityResponse.class);
        return cityResponse;
    }

    private String getRequestUrl(CityRequest request){
        StringBuilder url = new StringBuilder();
        url.append(properties.getAmap().getCity().getUrl());
        url.append("key=");
        url.append(properties.getAmap().getCity().getKey());
        if(StringUtils.isNotBlank(request.getKeywords())){
            url.append("&keywords=");
            url.append(request.getKeywords());
        }
        if(request.getSubdistrict() != null){
            url.append("&subdistrict=");
            url.append(request.getSubdistrict());
        }
        if(request.getPage() != null){
            url.append("&page=");
            url.append(request.getPage());
        }
        if(request.getOffset() != null){
            url.append("&offset=");
            url.append(request.getOffset());
        }
        if(StringUtils.isNotBlank(request.getExtensions())){
            url.append("&extensions=");
            url.append(request.getExtensions());
        }
        if(StringUtils.isNotBlank(request.getFilter())){
            url.append("&filter=");
            url.append(request.getFilter());
        }
        if(StringUtils.isNotBlank(request.getCallback())){
            url.append("&callback=");
            url.append(request.getCallback());
        }
        if(StringUtils.isNotBlank(request.getOutput())){
            url.append("&output=");
            url.append(request.getOutput());
        }
        return url.toString();
    }
}
