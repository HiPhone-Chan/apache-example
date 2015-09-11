package com.chf.example.apache.cxf.soap;

import javax.xml.ws.Endpoint;

public class SoapServer {

    private String address;

    private Object implementor;

    private Endpoint endpoint;

    public SoapServer(String address, Object implementor) {
        this.address = address;
        this.implementor = implementor;
    }

    public void start() {
        endpoint = Endpoint.publish(address, implementor);
    }

    public void stop() {
        endpoint.stop();
    }

    public static void main(String[] args) throws Exception {
        SoapService implementor = new SoapServiceImpl();
        String address = "http://localhost:9000/helloWorld";
        SoapServer server = new SoapServer(address, implementor);
        server.start();
    }

}
