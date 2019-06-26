package com.ls.weathercityamapclient.vo;

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
public class CityResponse {

    /**
     * 返回结果状态值
     * 值为0或1，0表示失败；1表示成功
     */
    private Integer status;

    /**
     * 返回状态说明
     * 返回状态说明，status为0时，info返回错误原因，否则返回“OK”。
     */
    private String info;

    /**
     * 状态码
     * 返回状态说明，10000代表正确，详情参阅info状态表
     */
    private String infocode;

    /**
     * 建议结果列表
     */
    private Suggestion suggestion;

    /**
     * 行政区列表
     */
    private List<District> districts;
}
