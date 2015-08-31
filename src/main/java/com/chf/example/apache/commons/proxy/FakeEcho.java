package com.chf.example.apache.commons.proxy;

public class FakeEcho {

    public String echo(String msg) {
        System.out.println("fake " + msg);
        return "asdasd" + msg;
    }
    
    public String echo2(String msg) {
        System.out.println("fake2 " + msg);
        return "1232" + msg;
    }
}
