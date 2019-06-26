package com.ls.weatherservice.vo.heweather;

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
public class HeLifestyleForecast {
    /**
     * 预报日期，例如2017-12-30
     */
    private Date date;
    /**
     * 生活指数简介
     */
    private String brf;
    /**
     * 生活指数详细描述
     */
    private String txt;
    /**
     * 生活指数类型 comf：舒适度指数、cw：洗车指数、drsg：穿衣指数、flu：感冒指数、sport：运动指数、trav：旅游指数、uv：紫外线指数、air：空气污染扩散条件指数、ac：空调开启指数、ag：过敏指数、gl：太阳镜指数、mu：化妆指数、airc：晾晒指数、ptfc：交通指数、fsh：钓鱼指数、spi：防晒指数
     */
    private String type;
}
