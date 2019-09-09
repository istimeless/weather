package com.istimeless.weathercity.service;

import com.istimeless.weathercity.properties.CityProperties;
import com.istimeless.weathercommon.vo.CityRequest;
import com.istimeless.weathercommon.vo.CityResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author lijiayin
 */
@Slf4j
@Service
public class CityInfoService {

    private final CityProperties properties;

    private final RestTemplate restTemplate;

    public CityInfoService(CityProperties properties, RestTemplate restTemplate) {
        this.properties = properties;
        this.restTemplate = restTemplate;
    }

    public CityResponse cityInfo(CityRequest request) {
        String url = getRequestUrl(request);
        log.info("请求城市信息url：{}", url);
        CityResponse result = restTemplate.getForObject(url, CityResponse.class);
        log.info("请求城市信息返回结果：{}", result);
        return result;
    }

    private String getRequestUrl(CityRequest request) {
        StringBuilder url = new StringBuilder();
        url.append(properties.getUrl());
        url.append("key=");
        url.append(properties.getKey());
        if (StringUtils.isNotBlank(request.getKeywords())) {
            url.append("&keywords=");
            url.append(request.getKeywords());
        }
        if (request.getSubdistrict() != null) {
            url.append("&subdistrict=");
            url.append(request.getSubdistrict());
        }
        if (request.getPage() != null) {
            url.append("&page=");
            url.append(request.getPage());
        }
        if (request.getOffset() != null) {
            url.append("&offset=");
            url.append(request.getOffset());
        }
        if (StringUtils.isNotBlank(request.getExtensions())) {
            url.append("&extensions=");
            url.append(request.getExtensions());
        }
        if (StringUtils.isNotBlank(request.getFilter())) {
            url.append("&filter=");
            url.append(request.getFilter());
        }
        if (StringUtils.isNotBlank(request.getCallback())) {
            url.append("&callback=");
            url.append(request.getCallback());
        }
        if (StringUtils.isNotBlank(request.getOutput())) {
            url.append("&output=");
            url.append(request.getOutput());
        }
        return url.toString();
    }
}
