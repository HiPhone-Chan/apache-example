package com.chf.example.apache.zest.assemble;

import org.qi4j.api.structure.Application;
import org.qi4j.api.structure.Module;
import org.qi4j.bootstrap.Energy4Java;
import org.qi4j.envisage.Envisage;

import com.chf.example.apache.zest.composite.Speaker;

public class Main {

    private static Energy4Java qi4j;

    private static Application application;

    public static void main(String[] args) throws Exception {
        qi4j = new Energy4Java();

        application = qi4j.newApplication(new MyApplicationAssembler());

        installShutdownHook();

        Module other = application.findModule("My Layer1", "My Module1");
        Speaker speaker = other.newTransient(Speaker.class);

        System.out.println(speaker.sayHello( ));

        new Envisage().run(application.descriptor());
    }

    private static void installShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                if (application != null) {
                    try {
                        application.passivate();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }));
    }
}
