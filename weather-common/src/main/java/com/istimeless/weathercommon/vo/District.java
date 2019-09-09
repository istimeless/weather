package com.istimeless.weathercommon.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class District {

    /**
     * 城市编码
     */
    @JsonIgnore
    private String citycode;

    /**
     * 区域编码
     * 街道没有独有的adcode，均继承父类（区县）的adcode
     */
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
     * 下级行政区列表，包含district元素
     */
    private List<District> districts;
}
