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
public class HeDailyForecast {
    /**
     * 预报日期	
     */
    private String date;
    /**
     * 日出时间
     */
    private String sr;
    /**
     * 日落时间
     */
    private String ss;
    /**
     * 月升时间
     */
    private String mr;
    /**
     * 月落时间
     */
    private String ms;
    /**
     * 最高温度
     */
    @JsonProperty("tmp_max")
    private Integer tmpMax;
    /**
     * 最低温度
     */
    @JsonProperty("tmp_min")
    private Integer tmpMin;
    /**
     * 白天天气状况代码
     */
    @JsonProperty("cond_code_d")
    private Integer condCodeD;
    /**
     * 夜间天气状况代码
     */
    @JsonProperty("cond_code_n")
    private Integer condCodeN;
    /**
     * 白天天气状况描述
     */
    @JsonProperty("cond_txt_d")
    private String condTxtD;
    /**
     * 晚间天气状况描述
     */
    @JsonProperty("cond_txt_n")
    private String condTxtN;
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
     * 降水量
     */
    private Float pcpn;
    /**
     * 降水概率
     */
    private Integer pop;
    /**
     * 大气压强
     */
    private Integer pres;
    /**
     * 紫外线强度指数
     */
    @JsonProperty("uv_index")
    private Integer uvIndex;
    /**
     * 能见度，单位：公里
     */
    private Integer vis;
}
