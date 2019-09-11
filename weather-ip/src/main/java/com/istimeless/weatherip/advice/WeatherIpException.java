package com.istimeless.weatherip.advice;

import lombok.Getter;

/**
 * @author lijiayin
 */
@Getter
public class WeatherIpException extends RuntimeException {

    private Integer code;

    public WeatherIpException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public WeatherIpException(WeatherIpEnum weatherIpEnum) {
        super(weatherIpEnum.getMsg());
        this.code = weatherIpEnum.getCode();
    }
}
