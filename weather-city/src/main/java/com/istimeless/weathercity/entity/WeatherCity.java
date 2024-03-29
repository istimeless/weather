package com.istimeless.weathercity.entity;

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
@Table(name = "weather_city")
public class WeatherCity {

    /**
     * 区域编码
     * 街道没有独有的adcode，均继承父类（区县）的adcode
     */
    @Id
    private String adcode;

    /**
     * 行政区名称
     */
    private String name;

    /**
     * 行政区边界坐标点
     * 当一个行政区范围，由完全分隔两块或者多块的地块组成，每块地的 polyline 坐标串以 | 分隔 。
     * 如北京 的 朝阳区
     */
    private String polyline;

    /**
     * 城市中心点
     * 在区县级别，有28个区县不能返回中心点
     * 在乡镇/街道界别，有9262个乡镇/街道不能返回中心点
     */
    private String center;

    /**
     * 行政区划级别
     * country:国家
     * province:省份（直辖市会在province和city显示）
     * city:市（直辖市会在province和city显示）
     * district:区县
     * street:街道
     */
    private String level;

    /**
     * 上一级adcode
     */
    private String parent;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
