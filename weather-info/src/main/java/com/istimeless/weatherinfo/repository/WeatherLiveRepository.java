package com.istimeless.weatherinfo.repository;

import com.istimeless.weatherinfo.entity.WeatherLive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author lijiayin
 */
public interface WeatherLiveRepository extends JpaRepository<WeatherLive, String>, JpaSpecificationExecutor<WeatherLive> {
}
