package com.chf.example.apache.zest.composite;

import org.qi4j.api.injection.scope.This;

public class SayHelloMixin implements Speaker {

    @This
    private MyProperty state;

    @Override
    public String sayHello() {
        return "Hello, " + state.name().get();
    }

}
