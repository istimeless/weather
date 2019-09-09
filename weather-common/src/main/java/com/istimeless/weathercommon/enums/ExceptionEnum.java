package com.istimeless.weathercommon.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author lijiayin
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnum {

    /**
     * 返回编码
     */
    SUCCESS(1, "成功"),

    SERVICE_FAIL(8888, "服务调用失败，请稍后再试！"),

    DEFAULT(9999, "未知系统异常");
    private Integer code;

    private String msg;
}
