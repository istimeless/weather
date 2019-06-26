package com.ls.weathercityamapservice.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author lijiayin
 */
@Data
@Component
@ConfigurationProperties(prefix = "weather.amap")
public class WeatherProperties {
    private String url;
    private String key;
}
