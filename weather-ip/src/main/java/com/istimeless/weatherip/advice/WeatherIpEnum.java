package com.istimeless.weatherip.advice;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author lijiayin
 */
@Getter
@AllArgsConstructor
public enum WeatherIpEnum {

    /**
     * 返回编码
     */
    SUCCESS(1, "成功"),

    CITY_NOT_EXIST(1001, "城市不存在"),

    SERVICE_FAIL(8888, "服务调用失败，请稍后再试！"),

    DEFAULT(9999, "未知系统异常");
    private Integer code;

    private String msg;
}
