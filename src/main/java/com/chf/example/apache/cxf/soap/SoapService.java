package com.chf.example.apache.cxf.soap;

import javax.jws.WebService;

@WebService
public interface SoapService {

    public String operation();

    default public String sayHi(String text) {
        return "Hello " + text;
    }
}
