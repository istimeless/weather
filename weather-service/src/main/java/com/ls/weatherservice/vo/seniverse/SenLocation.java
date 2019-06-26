package com.ls.weatherservice.vo.seniverse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lijiayin
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SenLocation {
    private String id;
    private String name;
    private String country;
    private String path;
    private String timezone;
    private String timezone_offset;
}
