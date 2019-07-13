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
    ALL("all", "forecast", "天气预报"),
    BASE("base", "live", "实时天气");
    
    private String code;
    
    private String key;
    
    private String msg;
    
}
