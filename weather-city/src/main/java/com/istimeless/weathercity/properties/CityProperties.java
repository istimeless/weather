package com.istimeless.weathercity.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author lijiayin
 */
@Data
@Component
@RefreshScope
@ConfigurationProperties(prefix = "weather.city")
public class CityProperties {

    private String url;

    private String key;
}
