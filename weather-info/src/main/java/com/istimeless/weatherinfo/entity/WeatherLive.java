package com.istimeless.weatherinfo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


/**
 * @author lijiayin
 */
@Data
@Entity
@Builder
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "weather_info")
public class WeatherLive {

    /**
     * 区域编码 + 数据发布的时间
     */
    @Id
    private String id;

    /**
     * 省份名
     */
    private String province;

    /**
     * 城市名
     */
    private String city;

    /**
     * 区域编码
     */
    private String adcode;

    /**
     * 天气现象（汉字描述）
     */
    private String weather;

    /**
     * 实时气温，单位：摄氏度
     */
    private Integer temperature;

    /**
     * 风向描述
     */
    private String winddirection;

    /**
     * 风力级别，单位：级
     */
    private String windpower;

    /**
     * 空气湿度
     */
    private Integer humidity;

    /**
     * 数据发布的时间
     */
    private String reporttime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
