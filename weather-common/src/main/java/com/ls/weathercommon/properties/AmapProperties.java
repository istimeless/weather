package com.ls.weathercommon.properties;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author lijiayin
 */
@Data
@Component
public class AmapProperties {
    
    private CityProperties city;
    
    private BasicProperties basic;
}
