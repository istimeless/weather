package com.ls.weatherservice.vo.heweather;

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
public class HeUpdate {

    /**
     * 当地时间，24小时制，格式yyyy-MM-dd HH:mm
     */
    private Date loc;
    /**
     * UTC时间，24小时制，格式yyyy-MM-dd HH:mm
     */
    private Date utc;
}
