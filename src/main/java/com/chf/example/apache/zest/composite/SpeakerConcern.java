package com.chf.example.apache.zest.composite;

import org.qi4j.api.concern.ConcernOf;

public class SpeakerConcern extends ConcernOf<Speaker> implements Speaker {

    @Override
    public String sayHello() {
        return next.sayHello() + "~~";
    }

}
