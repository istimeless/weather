package com.ls.weathercityamapclient.client;

import com.ls.weathercommon.enums.ExceptionEnum;
import com.ls.weathercommon.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;
import java.util.Set;

/**
 * @author lijiayin
 */
@FeignClient(name = "weather-gateway", fallback = WeatherCityClient.WeatherCityClientFallBack.class)
public interface WeatherCityClient {

    /**
     * 根据城市名称获取城市编码
     * @param cityName
     * @return
     */
    @GetMapping("/city/city/cityCode/{cityName}")
    Result<Map<String, String>> cityNameCodeMap(@PathVariable("cityName") String cityName);

    /**
     * 根据城市编码，获取当前城市的下一级城市
     * @param cityCode
     * @return
     */
    @GetMapping("/city/city/cityCodeNameMap/{cityCode}")
    Result<Map<Object, Object>> cityCodeNameMap(@PathVariable(value = "cityCode", required = false) String cityCode);

    @Component
    class WeatherCityClientFallBack implements WeatherCityClient{

        @Override
        public Result<Map<String, String>> cityNameCodeMap(String cityName) {
            return Result.failure(ExceptionEnum.SERVICE_FAIL);
        }

        @Override
        public Result<Map<Object, Object>> cityCodeNameMap(String cityCode) {
            return Result.failure(ExceptionEnum.SERVICE_FAIL);
        }
    }
}
