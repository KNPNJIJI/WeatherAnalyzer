package com.stosoft.weatheranalyzer.service;

import com.stosoft.weatheranalyzer.data.WeatherInf;
import com.stosoft.weatheranalyzer.data.WeatherInfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;

import static com.stosoft.weatheranalyzer.service.CallWheatherService.CallAPIWheatherService;

@Service
public class SchedulerService {

    @Autowired
    WeatherInfRepository repository;

    @Scheduled(initialDelayString = "${scheduler.start}", fixedDelayString = "${scheduler.delay}")
    public void doWork() throws IOException, ParseException {

        // get Wheather information
        WeatherInf weatherInf = CallAPIWheatherService();
        System.out.println("Scheduled end");
        repository.save(weatherInf);
    }
}
