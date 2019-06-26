package com.ls.weathercollectamapclient.vo;

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
public class WeatherResponse {

    /**
     * 返回状态	
     * 
     * 值为0或1
     *
     * 1：成功；0：失败
     */
    private Integer status;

    /**
     * 返回结果总数目
     */
    private Integer count;

    /**
     * 返回的状态信息
     */
    private String info;

    /**
     * 返回状态说明,10000代表正确
     */
    private String infocode;

    /**
     * 实况天气数据信息
     */
    private List<Live> lives;

    /**
     * 预报天气信息数据
     */
    private List<Forecast> forecasts;
}
