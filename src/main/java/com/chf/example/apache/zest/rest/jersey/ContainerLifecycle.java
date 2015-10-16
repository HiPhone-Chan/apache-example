package com.chf.example.apache.zest.rest.jersey;

import org.glassfish.jersey.server.spi.Container;
import org.glassfish.jersey.server.spi.ContainerLifecycleListener;
import org.qi4j.api.activation.ActivationException;
import org.qi4j.api.activation.PassivationException;
import org.qi4j.api.structure.Application;

public class ContainerLifecycle implements ContainerLifecycleListener {

    private Application application;

    public ContainerLifecycle(Application application) {
        this.application = application;
    }

    @Override
    public void onStartup(Container container) {
        try {
            application.activate();
        } catch (ActivationException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }

    @Override
    public void onReload(Container container) {
        try {
            application.passivate();
            application.activate();
        } catch (PassivationException | ActivationException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }

    }

    @Override
    public void onShutdown(Container container) {
        try {
            application.passivate();
        } catch (PassivationException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }

}
