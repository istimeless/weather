package com.ls.weatherservice.properties;

import lombok.Data;

/**
 * @author lijiayin
 */
@Data
public class SenWeatherProperties {
    private String url;
    private String privateKey;
    private String publicKey;
}
