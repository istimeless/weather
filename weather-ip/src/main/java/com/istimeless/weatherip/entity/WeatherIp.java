package com.istimeless.weatherip.entity;

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
@Table(name = "weather_ip")
public class WeatherIp {

    /**
     * ip地址
     */
    @Id
    private String ip;
    /**
     * 省份名称
     *
     * 若为直辖市则显示直辖市名称；
     *
     * 如果在局域网 IP网段内，则返回“局域网”；
     *
     * 非法IP以及国外IP则返回空
     */
    private String province;

    /**
     * 城市名称
     *
     * 若为直辖市则显示直辖市名称；
     *
     * 如果为局域网网段内IP或者非法IP或国外IP，则返回空
     */
    private String city;

    /**
     * 城市的adcode编码
     */
    private String adcode;

    /**
     * 所在城市矩形区域范围
     *
     * 所在城市范围的左下右上对标对
     */
    private String rectangle;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
