package com.istimeless.weathercommon.vo;

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
public class Forecast {

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
     * 数据发布的时间
     */
    private String reporttime;

    /**
     * 预报数据list结构，元素cast,按顺序为当天、第二天、第三天的预报数据
     */
    private List<Cast> casts;
}
