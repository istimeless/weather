package com.istimeless.weatherredis.advice;

import lombok.Getter;

/**
 * @author lijiayin
 */
@Getter
public class WeatherRedisException extends RuntimeException {
    
    private Integer code;

    public WeatherRedisException(Integer code, String message){
        super(message);
        this.code = code;
    }

    public WeatherRedisException(WeatherRedisEnum weatherRedisEnum){
        super(weatherRedisEnum.getMsg());
        this.code = weatherRedisEnum.getCode();
    }
}
