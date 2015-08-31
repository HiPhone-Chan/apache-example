package com.chf.example.apache.commons.proxy;

public class EchoImpl implements Echo {

    public String echo(String msg) {
        System.out.println(msg);
        return msg;
    }
}
