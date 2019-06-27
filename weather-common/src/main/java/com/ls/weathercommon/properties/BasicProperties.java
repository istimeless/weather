package com.ls.weathercommon.properties;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author lijiayin
 */
@Data
@Component
public class BasicProperties {

    private String url;

    private String key;
}
