package com.ls.weatherservice.vo.seniverse;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author lijiayin
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SenResult {
    
    private SenLocation location;
    
    private SenNow now;

    /**
     * 数据更新时间（该城市的本地时间）
     */
    @JsonProperty("last_update")
    private Date lastUpdate;
}
