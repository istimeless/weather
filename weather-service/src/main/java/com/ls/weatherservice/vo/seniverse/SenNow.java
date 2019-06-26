package com.ls.weatherservice.vo.seniverse;

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
public class SenNow {
    /**
     * 天气现象文字
     */
    private String text;
    /**
     * 天气现象代码
     */
    private Integer code;
    /**
     * 温度，单位为c摄氏度或f华氏度
     */
    private Integer temperature;
    /**
     * 体感温度，单位为c摄氏度或f华氏度
     */
    @JsonProperty("feels_like")
    private Integer feelsLike;
    /**
     * 气压，单位为mb百帕或in英寸
     */
    private Integer pressure;
    /**
     * 相对湿度，0~100，单位为百分比
     */
    private Integer humidity;
    /**
     * 能见度，单位为km公里或mi英里
     */
    private Float visibility;
    /**
     * 风向文字
     */
    @JsonProperty("wind_direction")
    private String windDirection;
    /**
     * 风向角度，范围0~360，0为正北，90为正东，180为正南，270为正西
     */
    @JsonProperty("wind_direction_degree")
    private Integer windDirectionDegree;
    /**
     * 风速，单位为km/h公里每小时或mph英里每小时
     */
    @JsonProperty("wind_speed")
    private Float windSpeed;
    /**
     * 风力等级，请参考：http://baike.baidu.com/view/465076.htm
     */
    @JsonProperty("wind_scale")
    private Integer windScale;
    /**
     * 云量，单位%，范围0~100，天空被云覆盖的百分比 #目前不支持中国城市#
     */
    private Integer clouds;
    /**
     * 露点温度，请参考：http://baike.baidu.com/view/118348.htm #目前不支持中国城市#
     */
    @JsonProperty("dew_point")
    private Integer dewPoint;
}
