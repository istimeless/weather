package com.ls.weathercollectamapservice.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author lijiayin
 */
@Getter
@AllArgsConstructor
public enum WeatherTypeEnum {

    /**
     * 查询天气类型
     */
    ALL("all", "天气预报"),
    BASE("base", "实时天气");
    
    private String code;
    
    private String msg;
    
}
