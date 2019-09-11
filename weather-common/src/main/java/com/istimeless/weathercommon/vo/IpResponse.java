package com.istimeless.weathercommon.vo;

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
public class IpResponse {

    /**
     * 返回状态
     * <p>
     * 值为0或1
     * <p>
     * 1：成功；0：失败
     */
    private Integer status;

    /**
     * 返回的状态信息
     */
    private String info;

    /**
     * 返回状态说明,10000代表正确
     */
    private String infocode;

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
}
