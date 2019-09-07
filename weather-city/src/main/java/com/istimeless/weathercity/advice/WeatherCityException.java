package com.istimeless.weathercity.advice;

import lombok.Getter;

/**
 * @author lijiayin
 */
@Getter
public class WeatherCityException extends RuntimeException {
    
    private Integer code;

    public WeatherCityException(Integer code, String message){
        super(message);
        this.code = code;
    }

    public WeatherCityException(WeatherCityEnum weatherCityEnum){
        super(weatherCityEnum.getMsg());
        this.code = weatherCityEnum.getCode();
    }
}
