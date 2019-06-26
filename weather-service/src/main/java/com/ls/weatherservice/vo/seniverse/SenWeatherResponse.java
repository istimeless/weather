package com.ls.weatherservice.vo.seniverse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author lijiayin
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SenWeatherResponse {
    private String status;
    @JsonProperty("status_code")
    private String statusCode;
    private List<SenResult> results;
}
