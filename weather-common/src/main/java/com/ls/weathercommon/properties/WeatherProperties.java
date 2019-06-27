package com.ls.weathercommon.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author lijiayin
 */
@Data
@Component
@ConfigurationProperties(prefix = "weather")
public class WeatherProperties {
    
    private AmapProperties amap;
    
    private GatewayProperties gateway;
    
}
