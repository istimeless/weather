package com.ls.weatherservice.vo.heweather;

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
public class HeWeatherResponse {
    @JsonProperty("HeWeather6")
    private List<HeWeather> heHeWeather6;
}
