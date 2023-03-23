package com.stosoft.weatheranalyzer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableScheduling
@SpringBootApplication
@EnableSwagger2
public class WeatherAnalyzerApplication {

    public static void main(String[] args) {

        System.setProperty("server.port", "8082");

        SpringApplication.run(WeatherAnalyzerApplication.class, args);
    }

}
