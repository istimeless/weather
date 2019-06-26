package com.ls.weatherservice.vo.heweather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * @author lijiayin
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HeWeather {
    /**
     * 基础信息
     */
    private HeBasic basic;
    /**
     * 接口状态
     */
    private String status;
    /**
     * 接口更新时间
     */
    private HeUpdate update;
    /**
     * 实况天气
     */
    private HeNow now;
    /**
     * 天气预报
     */
    @JsonProperty("daily_forecast")
    private List<HeDailyForecast> dailyForecast;
    /**
     * 逐小时预报
     */
    private List<HeHourly> hourly;
    /**
     * 生活指数
     */
    private List<HeLifestyle> lifestyle;
    /**
     * 生活指数预报
     */
    @JsonProperty("lifestyle_forecast")
    private List<HeLifestyleForecast> lifestyleForecast;
}
