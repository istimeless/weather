package com.ls.weatherservice.vo.heweather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author lijiayin
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HeHourly {
    /**
     * 预报时间，格式yyyy-MM-dd hh:mm
     */
    private Date time;
    /**
     * 温度
     */
    private Integer tmp;
    /**
     * 天气状况代码
     */
    @JsonProperty("cond_code")
    private Integer condCode;
    /**
     * 天气状况描述
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
     * 风力
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
     * 大气压强
     */
    private Integer pres;
    /**
     * 降水概率，百分比
     */
    private Integer pop;
    /**
     * 露点温度
     */
    private Integer dew;
    /**
     * 云量
     */
    private Integer cloud;
}
