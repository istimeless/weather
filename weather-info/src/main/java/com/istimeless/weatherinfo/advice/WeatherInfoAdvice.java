package com.istimeless.weatherinfo.advice;

import com.istimeless.weathercommon.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author lijiayin
 */
@Slf4j
@RestControllerAdvice
public class WeatherInfoAdvice implements ResponseBodyAdvice {
    
    @ExceptionHandler(Exception.class)
    public Result orderQueryAdvice(Exception e){
        log.error("捕获未知异常：{}", e.getMessage(), e);
        return Result.failure(WeatherInfoEnum.DEFAULT.getCode(), e.getMessage());
    }

    @ExceptionHandler(WeatherInfoException.class)
    public Result orderQueryAdvice(WeatherInfoException e){
        log.error("捕获自定义异常：{}", e.getMessage(), e);
        return Result.failure(e.getCode(), e.getMessage());
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter,
                                  MediaType mediaType, Class aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {
        if(o instanceof Result){
            return o;
        }
        return Result.success(o);
    }
}
