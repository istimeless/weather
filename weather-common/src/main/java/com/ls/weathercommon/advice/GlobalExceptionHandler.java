package com.ls.weathercommon.advice;

import com.ls.weathercommon.enums.ExceptionEnum;
import com.ls.weathercommon.exception.GlobalException;
import com.ls.weathercommon.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author lijiayin
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler(Exception e){
        log.error("捕获未知异常，msg={}", e.getMessage(), e);  
        return Result.failure(ExceptionEnum.DEFAULT);
    }

    @ExceptionHandler(value = GlobalException.class)
    public Result exceptionHandler(GlobalException e){
        Integer code = e.getCode();
        String msg = e.getMessage();
        log.error("捕获全局异常，code={},msg={}。", code, msg, e);
        return Result.failure(code, msg);
    }
}
