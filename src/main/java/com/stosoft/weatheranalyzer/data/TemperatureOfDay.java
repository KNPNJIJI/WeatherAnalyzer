package com.stosoft.weatheranalyzer.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TemperatureOfDay {

    private double average_temp;
    private LocalDate date;
}
