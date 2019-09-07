package com.istimeless.weathercity.service.impl;

import com.istimeless.weathercity.client.RedisClient;
import com.istimeless.weathercity.entity.WeatherCity;
import com.istimeless.weathercity.repository.WeatherCityRepository;
import com.istimeless.weathercity.service.SaveCityInfoService;
import com.istimeless.weathercity.vo.CityResponse;
import com.istimeless.weathercity.vo.District;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @author lijiayin
 */
@Slf4j
@Service
public class SaveCityInfoServiceImpl implements SaveCityInfoService {
    

    private final WeatherCityRepository weatherCityRepository;

    private final RedisClient redisClient;

    public SaveCityInfoServiceImpl(WeatherCityRepository weatherCityRepository,
                                   RedisClient redisClient) {
        this.weatherCityRepository = weatherCityRepository;
        this.redisClient = redisClient;
    }

    @Override
    public void saveCityInfo(CityResponse response) {
        List<WeatherCity> weatherCities = new ArrayList<>();
        getCityList(response.getDistricts(), null, weatherCities);
        Map<String, Object> redisMap = new HashMap<>(5100);
        weatherCities.forEach(weatherCity -> redisMap.put(weatherCity.getName(), weatherCity));
        redisClient.set(redisMap);
        weatherCityRepository.saveAll(weatherCities);
    }
    
    private void getCityList(List<District> districts, String parent, List<WeatherCity> weatherCities){
        districts.forEach(district -> {
            Date now = new Date();
            weatherCities.add(WeatherCity.builder()
                    .adcode(district.getAdcode())
                    .name(district.getName())
                    .polyline(district.getPolyline())
                    .center(district.getCenter())
                    .level(district.getLevel())
                    .parent(parent)
                    .createTime(now)
                    .updateTime(now)
                    .build());
            if(!CollectionUtils.isEmpty(district.getDistricts())){
                getCityList(district.getDistricts(), district.getAdcode(), weatherCities);
            }
        });
    }
}
