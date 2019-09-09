package com.istimeless.weatherinfo.advice;

import lombok.Getter;

/**
 * @author lijiayin
 */
@Getter
public class WeatherInfoException extends RuntimeException {

    private Integer code;

    public WeatherInfoException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public WeatherInfoException(WeatherInfoEnum weatherInfoEnum) {
        super(weatherInfoEnum.getMsg());
        this.code = weatherInfoEnum.getCode();
    }
}
