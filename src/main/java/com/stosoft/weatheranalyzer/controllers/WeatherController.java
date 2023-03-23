package com.stosoft.weatheranalyzer.controllers;

import com.stosoft.weatheranalyzer.data.TemperatureOfDay;
import com.stosoft.weatheranalyzer.data.WeatherInfDTO;
import com.stosoft.weatheranalyzer.jsonservice.Request;
import com.stosoft.weatheranalyzer.service.WeatherInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WeatherController {

    @Autowired
    private WeatherInfService weatherInfService;

    @ResponseBody
    @GetMapping("/now")
    public WeatherInfDTO getWeather(){
        return weatherInfService.getActualWeather();
    }

    @ResponseBody
    @PostMapping("/period")
    public List<TemperatureOfDay> getPeriodWeather(@RequestBody Request input){

        return weatherInfService.getAverageWeather(input.from, input.to);
    }

}
