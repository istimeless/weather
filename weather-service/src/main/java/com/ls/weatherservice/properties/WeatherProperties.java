package com.ls.weatherservice.properties;

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
    private HeWeatherProperties heWeather;
    private SenWeatherProperties senWeather;
}
