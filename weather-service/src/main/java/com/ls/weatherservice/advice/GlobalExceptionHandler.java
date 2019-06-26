package com.ls.weatherservice.advice;

import com.ls.weatherservice.vo.ResultResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * @author lijiayin
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultResponse<Object> handler(Exception e){
        return ResultResponse.builder()
                .code(9999)
                .msg(e.getMessage())
                .build();
    }
}
