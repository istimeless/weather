package com.ls.weathercityamapservice.service.impl;

import com.google.common.collect.Maps;
import com.ls.weathercityamapclient.vo.CityRequest;
import com.ls.weathercityamapclient.vo.CityResponse;
import com.ls.weathercityamapclient.vo.District;
import com.ls.weathercityamapservice.constant.WeatherConstant;
import com.ls.weathercityamapservice.service.GetCityService;
import com.ls.weathercityamapservice.service.WeatherCityService;
import com.ls.weathercommon.enums.ExceptionEnum;
import com.ls.weathercommon.exception.GlobalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author lijiayin
 */
@Slf4j
@Service
public class WeatherCityServiceImpl implements WeatherCityService {
    
    private final RedisTemplate<String, Object> redisTemplate;
    
    private final GetCityService getCityService;

    @Autowired
    public WeatherCityServiceImpl(RedisTemplate<String, Object> redisTemplate, GetCityService getCityService) {
        this.redisTemplate = redisTemplate;
        this.getCityService = getCityService;
    }

    @Override
    public Map<String, String> getCityCodeByCityName(String cityName) {
        String key = WeatherConstant.CACHE_PREFIX + "city:name-code-key:" + cityName + "*";
        Set<String> keys = redisTemplate.keys(key);
        if(!CollectionUtils.isEmpty(keys)){
            return getCityCodeMap(keys);
        }
        cityNameCodeKey();
        keys = redisTemplate.keys(key);
        if(!CollectionUtils.isEmpty(keys)){
            return getCityCodeMap(keys);
        }else {
            throw new GlobalException(ExceptionEnum.CITY_NOT_EXIST);
        }
    }

    private Map<String, String> getCityCodeMap(Set<String> keys) {
        Map<String, String> map = Maps.newHashMap();
        keys.forEach(name -> {
            String code = (String)redisTemplate.opsForValue().get(name);
            name = name.substring(name.lastIndexOf(":"));
            map.put(name, code);
        });
        return map;
    }


    @Override
    public Map<Object, Object> cityCodeNameMap(CityRequest request) {
        String key = WeatherConstant.CACHE_PREFIX + "city:code-name-map:" + request.hashCode();
        Map<Object, Object> resp = redisTemplate.opsForHash().entries(key);
        if(!CollectionUtils.isEmpty(resp)){
            return resp;
        }

        CityResponse cityResponse = getCityService.cityInfo(request);
        Map<Object, Object> cityMap = Maps.newHashMap();
        if(cityResponse != null){
            addCityCodeName(cityResponse.getDistricts().get(0).getDistricts(), cityMap);
        }
        redisTemplate.opsForHash().putAll(key,cityMap);
        return cityMap;
    }
    
    /**
     * 城市名称-城市编码
     * @return
     */
    private void cityNameCodeKey() {
        Boolean hasKey = redisTemplate.hasKey(WeatherConstant.CACHE_PREFIX + "city:name-code-key:南京市");
        if(hasKey){
            return;
        }
        CityResponse cityResponse = getCityService.cityInfo(WeatherConstant.ALL_CITY);
        Map<String, String> cityMap = Maps.newHashMap();
        if(cityResponse != null){
            addCityNameCode(cityResponse.getDistricts(), cityMap);
        }
        redisTemplate.opsForValue().multiSet(cityMap);
    }
    
    private void addCityNameCode(List<District> districts, Map<String, String> cityMap){
        if(CollectionUtils.isEmpty(districts)){
            return;
        }
        districts.forEach(district -> {
            cityMap.put(WeatherConstant.CACHE_PREFIX + "city:name-code-key:" + district.getName(), district.getAdcode());
            addCityNameCode(district.getDistricts(), cityMap);
        });
    }

    private void addCityCodeName(List<District> districts, Map<Object, Object> cityMap){
        if(CollectionUtils.isEmpty(districts)){
            return;
        }
        districts.forEach(district -> {
            cityMap.put(district.getAdcode(), district.getName());
            addCityCodeName(district.getDistricts(), cityMap);
        });
    }
}
