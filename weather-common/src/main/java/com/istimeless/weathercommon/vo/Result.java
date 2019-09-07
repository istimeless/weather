package com.istimeless.weathercommon.vo;

import com.istimeless.weathercommon.enums.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lijiayin
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    
    private Integer code;
    
    private String msg;
    
    private T data;
    
    public static <T>Result<T> success(){
        return Result.<T>builder()
                .code(ExceptionEnum.SUCCESS.getCode())
                .build();
    }

    public static <T>Result<T> success(T data){
        return Result.<T>builder()
                .code(ExceptionEnum.SUCCESS.getCode())
                .data(data)
                .build();
    }

    public static <T>Result<T> failure(Integer code, String msg){
        return Result.<T>builder()
                .code(code)
                .msg(msg)
                .build();
    }

    public static <T>Result<T> failure(ExceptionEnum exceptionEnum){
        return Result.<T>builder()
                .code(exceptionEnum.getCode())
                .msg(exceptionEnum.getMsg())
                .build();
    }
}
