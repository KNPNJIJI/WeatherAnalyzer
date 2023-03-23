package com.stosoft.weatheranalyzer.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class WeatherInf {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private double temp_c;
    private double wind_mph;
    private double pressure_mb;
    private int humidity;
    private String condition_text;
    private String location_name;
    private String text_error;
    private LocalDate lastupdated;


    @Override
    public String toString() {
        return "WeatherInf{" +
                "id=" + id +
                ", temp_c=" + temp_c +
                ", wind_mph=" + wind_mph +
                ", pressure_mb=" + pressure_mb +
                ", humidity=" + humidity +
                ", condition_text='" + condition_text + '\'' +
                ", location_name='" + location_name + '\'' +
                ", text_error='" + text_error + '\'' +
                ", last_updated=" + lastupdated +
                '}';
    }
}


