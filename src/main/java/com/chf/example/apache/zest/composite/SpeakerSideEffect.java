package com.chf.example.apache.zest.composite;

import java.util.Date;

import org.qi4j.api.sideeffect.SideEffectOf;

public class SpeakerSideEffect extends SideEffectOf<Speaker> implements Speaker {

    @Override
    public String sayHello() {
        String r = result.sayHello();
        System.out.println(r + " " + new Date());
        return r + "!";
    }

}
