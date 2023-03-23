package com.stosoft.weatheranalyzer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stosoft.weatheranalyzer.data.WeatherInf;
import com.stosoft.weatheranalyzer.jsonservice.Root;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CallWheatherService {

    public static WeatherInf CallAPIWheatherService() throws IOException {

        // Call API Wheather and convert JSON to pojo
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
        .url("https://weatherapi-com.p.rapidapi.com/current.json?q=53.9%2C27.5667")
        .get()
        .addHeader("X-RapidAPI-Key", "beb8f6ceecmsh94225f31e76b066p1a99f4jsnfe80956a800d")
        .addHeader("X-RapidAPI-Host", "weatherapi-com.p.rapidapi.com")
        .build();

        Response response = client.newCall(request).execute();

        WeatherInf weatherInf = new WeatherInf();

        if (response.code() == 200) {
            ObjectMapper om = new ObjectMapper();
            Root root = om.readValue(response.body().string(), Root.class);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDate date = LocalDate.parse(root.current.last_updated, formatter);

            weatherInf.setTemp_c(root.current.temp_c);
            weatherInf.setWind_mph(root.current.wind_mph);
            weatherInf.setPressure_mb(root.current.pressure_mb);
            weatherInf.setHumidity(root.current.humidity);
            weatherInf.setCondition_text(root.current.condition.text);
            weatherInf.setLocation_name(root.location.name);
            weatherInf.setLastupdated(date);
        } else {
            weatherInf.setText_error(response.body().string());
        }

        return weatherInf;
        }
}
