package com.stosoft.weatheranalyzer.jsonservice;

//import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Request {
    public String from;
    //@JsonProperty("to")
    public String to;
}
