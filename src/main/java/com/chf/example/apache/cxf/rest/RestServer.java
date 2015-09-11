package com.chf.example.apache.cxf.rest;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;

public class RestServer {

    private Class<?>[] resourceClasses;

    private Server server;

    public RestServer(Class<?>... classes) {
        resourceClasses = classes;
    }

    public void start() {
        JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
        sf.setResourceClasses(resourceClasses);
        sf.setAddress("http://localhost:9000/");
        server = sf.create();
    }

    public void stop() {
        server.stop();
    }

    public static void main(String[] args) throws Exception {
        RestServer server = new RestServer(RestService.class);
        server.start();
    }

}
