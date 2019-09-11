package com.istimeless.weatherip.repository;

import com.istimeless.weatherip.entity.WeatherIp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author lijiayin
 */
public interface WeatherIpRepository extends JpaRepository<WeatherIp, String>, JpaSpecificationExecutor<WeatherIp> {
}
