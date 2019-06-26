package com.ls.weatherservice.vo.heweather;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class HeNow {
    /**
     * 体感温度，默认单位：摄氏度
     */
    private Integer fl;
    /**
     * 温度，默认单位：摄氏度
     */
    private Integer tmp;
    /**
     * 实况天气状况代码
     */
    @JsonProperty("cond_code")
    private Integer condCode;
    /**
     * 实况天气状况描述
     */
    @JsonProperty("cond_txt")
    private String condTxt;
    /**
     * 风向360角度
     */
    @JsonProperty("wind_deg")
    private Integer windDeg;
    /**
     * 风向
     */
    @JsonProperty("wind_dir")
    private String windDir;
    /**
     * 	风力
     */
    @JsonProperty("wind_sc")
    private String windSc;
    /**
     * 风速，公里/小时
     */
    @JsonProperty("wind_spd")
    private Integer windSpd;
    /**
     * 相对湿度
     */
    private Integer hum;
    /**
     * 	降水量
     */
    private Float pcpn;
    /**
     * 	大气压强
     */
    private Integer pres;
    /**
     * 能见度，默认单位：公里
     */
    private Integer vis;
    /**
     * 云量
     */
    private Integer cloud;
}
