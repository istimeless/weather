package com.istimeless.weatherinfo.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author lijiayin
 */
@Data
@Component
@ConfigurationProperties(prefix = "weather.info")
public class WeatherInfoProperties {

    private String url;

    private String key;
}
