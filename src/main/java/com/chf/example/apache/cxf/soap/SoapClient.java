package com.chf.example.apache.cxf.soap;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class SoapClient {

    private String url;

    private String namespaceURI;

    public SoapClient(String url, String namespaceURI) {
        this.url = url;
        this.namespaceURI = namespaceURI;
    }

    public <T> T getService(Class<T> clz) throws MalformedURLException {
        URL url = new URL(this.url);
        QName serviceName = new QName(namespaceURI, clz.getSimpleName());
        Service service = Service.create(url, serviceName);

        return service.getPort(clz);
    }

    public static void main(String[] args) throws Exception {
        String url = "http://localhost:9000/helloWorld?wsdl";
        String namespaceURI = "http://chf.com/";

        SoapClient client = new SoapClient(url, namespaceURI);
        SoapService soapService = client.getService(SoapService.class);
        System.out.println(soapService.operation());
    }

}
