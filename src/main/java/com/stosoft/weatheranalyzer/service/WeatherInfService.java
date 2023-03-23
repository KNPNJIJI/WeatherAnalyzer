package com.stosoft.weatheranalyzer.service;

import com.stosoft.weatheranalyzer.data.TemperatureOfDay;
import com.stosoft.weatheranalyzer.data.WeatherInf;
import com.stosoft.weatheranalyzer.data.WeatherInfDTO;
import com.stosoft.weatheranalyzer.data.WeatherInfRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class WeatherInfService {

    @Autowired
    private WeatherInfRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public WeatherInfDTO getActualWeather(){
        WeatherInf weatherInfFind = repository.findLastWeather();
        return convertToWeatherInfDTO(weatherInfFind);
    }

    public List<TemperatureOfDay> getAverageWeather(String fromRequest, String toRequest){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fromDate = LocalDate.parse(fromRequest, formatter);
        LocalDate toDate = LocalDate.parse(toRequest, formatter);

        List<WeatherInf> weatherInfList = repository.findAllByLastupdatedBetween(fromDate, toDate);

        Map<LocalDate, Double> mapTempOfDays = weatherInfList.stream()
                .collect(Collectors.groupingBy(
                        WeatherInf::getLastupdated,
                        Collectors.averagingDouble(WeatherInf::getTemp_c)));

        List<TemperatureOfDay> tempDays = new ArrayList<>();

        for (Map.Entry<LocalDate, Double> temOfDay : mapTempOfDays.entrySet()) {
            tempDays.add(new TemperatureOfDay(temOfDay.getValue(), temOfDay.getKey()));
        }

        return tempDays;
    }

    private WeatherInfDTO convertToWeatherInfDTO (WeatherInf weatherInf) {
        return modelMapper.map(weatherInf, WeatherInfDTO.class);
    }
}
