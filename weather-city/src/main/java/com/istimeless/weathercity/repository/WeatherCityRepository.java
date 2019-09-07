package com.istimeless.weathercity.repository;

import com.istimeless.weathercity.entity.WeatherCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author lijiayin
 */
public interface WeatherCityRepository extends JpaRepository<WeatherCity, String>, JpaSpecificationExecutor<WeatherCity> {
}
