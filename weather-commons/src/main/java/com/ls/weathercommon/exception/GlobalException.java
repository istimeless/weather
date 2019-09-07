package com.ls.weathercommon.exception;

import com.ls.weathercommon.enums.ExceptionEnum;
import lombok.Data;

/**
 * @author lijiayin
 */
@Data
public class GlobalException extends RuntimeException {
    
    private Integer code;
    
    public GlobalException(ExceptionEnum exceptionEnum){
        super(exceptionEnum.getMsg());
        this.code = exceptionEnum.getCode();
    }

    public GlobalException(ExceptionEnum exceptionEnum, String msg){
        super(msg);
        this.code = exceptionEnum.getCode();
    }
}
