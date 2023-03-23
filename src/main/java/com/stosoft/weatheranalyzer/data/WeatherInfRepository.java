package com.stosoft.weatheranalyzer.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface WeatherInfRepository extends CrudRepository<WeatherInf, Long> {

    //WeatherInf findFirstByOrderByIdDesc();
    @Query(
            value = "SELECT * FROM weather.weather_inf WHERE temp_c != 0 ORDER BY id DESC LIMIT 1",
            nativeQuery = true)
    WeatherInf findLastWeather();


    List<WeatherInf> findAllByLastupdatedBetween(LocalDate fromDate, LocalDate toDate);
}
