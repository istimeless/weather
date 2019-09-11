package com.istimeless.weatherinfo.client;

import com.istimeless.weathercommon.vo.Result;
import com.istimeless.weathercommon.vo.WeatherIpVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lijiayin
 */
@FeignClient(name = "weather-ip")
public interface WeatherIpClient {

    @GetMapping("/ip")
    Result<WeatherIpVO> ipInfo(@RequestParam String ip);
}
