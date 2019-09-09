package com.istimeless.weathercity.service;

import com.istimeless.weathercity.entity.WeatherCity;
import com.istimeless.weathercity.repository.WeatherCityRepository;
import com.istimeless.weathercommon.constant.CityConstant;
import com.istimeless.weathercommon.vo.CityResponse;
import com.istimeless.weathercommon.vo.District;
import com.istimeless.weathercommon.vo.WeatherCityVO;
import com.istimeless.weatherredis.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @author lijiayin
 */
@Slf4j
@Service
public class SaveCityInfoService {

    private final WeatherCityRepository weatherCityRepository;

    public SaveCityInfoService(WeatherCityRepository weatherCityRepository) {
        this.weatherCityRepository = weatherCityRepository;
    }

    public void saveCityInfo(CityResponse response) {
        //1.组装为list
        List<WeatherCity> weatherCities = new ArrayList<>();
        getCityList(response.getDistricts(), null, weatherCities);
        //2.保存城市代码+城市名称-城市对象
        Map<String, WeatherCityVO> cityVOMap = new HashMap<>(5100);
        weatherCities.forEach(weatherCity -> {
            WeatherCityVO weatherCityVO = new WeatherCityVO();
            BeanUtils.copyProperties(weatherCity, weatherCityVO);
            String key = CityConstant.CODE_NAME_PREFIX + weatherCity.getAdcode() + "-" + weatherCity.getName();
            cityVOMap.put(key, weatherCityVO);
        });
        RedisUtil.set(cityVOMap);
        //3.保存城市代码列表
        List<String> cityList = new ArrayList<>();
        weatherCities.forEach(weatherCity -> cityList.add(weatherCity.getAdcode()));
        RedisUtil.set(CityConstant.CITY_LIST, cityList);
        //4.保存城市到数据库
        weatherCityRepository.saveAll(weatherCities);
    }

    private void getCityList(List<District> districts, String parent, List<WeatherCity> weatherCities) {
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
            if (!CollectionUtils.isEmpty(district.getDistricts())) {
                getCityList(district.getDistricts(), district.getAdcode(), weatherCities);
            }
        });
    }
}
