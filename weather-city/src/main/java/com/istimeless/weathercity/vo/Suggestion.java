package com.istimeless.weathercity.vo;

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
public class Suggestion {

    /**
     * 建议关键字列表
     */
    private List<String> keywords;

    /**
     * 建议城市列表
     */
    private List<String> cites;
}
