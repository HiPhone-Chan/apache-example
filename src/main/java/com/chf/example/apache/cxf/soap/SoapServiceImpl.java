package com.chf.example.apache.cxf.soap;

import javax.jws.WebService;

@WebService(targetNamespace = "http://chf.com/", endpointInterface = "com.chf.example.apache.cxf.soap.SoapService", serviceName = "SoapService")
public class SoapServiceImpl implements SoapService {

    @Override
    public String operation() {
        return "operation";
    }

}
