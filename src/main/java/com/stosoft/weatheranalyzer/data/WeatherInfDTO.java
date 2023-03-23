package com.stosoft.weatheranalyzer.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherInfDTO {

    private double temp_c;
    private double wind_mph;
    private double pressure_mb;
    private int humidity;
    private String condition_text;
    private String location_name;
}
