package com.ls.weathercollectamapclient.vo;

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
public class Cast {

    /**
     * 日期
     */
    private String date;

    /**
     * 星期几
     */
    private Integer week;

    /**
     * 白天天气现象
     */
    private String dayweather;

    /**
     * 晚上天气现象
     */
    private String nightweather;

    /**
     * 白天温度
     */
    private Integer daytemp;

    /**
     * 晚上温度
     */
    private Integer nighttemp;

    /**
     * 白天风向
     */
    private String daywind;

    /**
     * 晚上风向
     */
    private String nightwind;

    /**
     * 白天风力
     */
    private String daypower;

    /**
     * 晚上风力
     */
    private String nightpower;
}
