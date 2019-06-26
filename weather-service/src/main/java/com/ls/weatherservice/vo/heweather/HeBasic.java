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
public class HeBasic {

    /**
     * 地区／城市名称
     */
    private String location;
    /**
     * 地区／城市ID
     */
    private String cid;
    /**
     * 地区／城市纬度
     */
    private String lat;
    /**
     * 地区／城市经度
     */
    private String lon;
    /**
     * 该地区／城市的上级城市
     */
    @JsonProperty("parent_city")
    private String parentCity;
    /**
     * 该地区／城市所属行政区域
     */
    @JsonProperty("admin_area")
    private String adminArea;
    /**
     * 该地区／城市所属国家名称
     */
    private String cnty;
    /**
     * 该地区／城市所在时区
     */
    private String tz;
}
