package com.ls.weatherservice.service;

import com.ls.weatherservice.vo.WeatherResponse;

/**
 * @author lijiayin
 */
public interface WeatherInfoService<T> {

    /**
     * 获取天气预报
     * 需要查询的城市或地区，可输入以下值：
     * 1. 城市ID：城市列表
     * 2. 经纬度格式：经度,纬度（经度在前纬度在后，英文,分隔，十进制格式，北纬东经为正，南纬西经为负
     * 3. 城市名称，支持中英文和汉语拼音
     * 4. 城市名称，上级城市 或 省 或 国家，英文,分隔，此方式可以在重名的情况下只获取想要的地区的天气数据，例如 西安,陕西
     * 5. IP
     * 6. 根据请求自动判断，根据用户的请求获取IP，通过 IP 定位并获取城市数据
     * 实例：
     * 1. location=CN101010100
     * 2. location=116.40,39.9
     * 3. location=北京、 location=北京市、 location=beijing
     * 4. location=朝阳,北京、 location=chaoyang,beijing
     * 5. location=60.194.130.1
     * 6. location=auto_ip
     * @param location
     * @return
     * @throws Exception
     */
    WeatherResponse<T> collectionWeatherInfo(String location) throws Exception;
}
