package com.chf.example.apache.zest.rest.jersey;

import java.lang.reflect.Type;

import javax.inject.Singleton;

import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.api.Injectee;
import org.glassfish.hk2.api.InjectionResolver;
import org.glassfish.hk2.api.ServiceHandle;
import org.glassfish.hk2.api.TypeLiteral;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.qi4j.api.injection.scope.Service;
import org.qi4j.api.injection.scope.Structure;
import org.qi4j.api.service.NoSuchServiceException;
import org.qi4j.api.structure.Application;
import org.qi4j.api.structure.Layer;
import org.qi4j.api.structure.Module;

public class ResourceInjector extends AbstractBinder {

    private final Application application;
    private final String layerName;
    private final String moduleName;

    public ResourceInjector(Application application, String layerName,
            String moduleName) {
        this.application = application;
        this.layerName = layerName;
        this.moduleName = moduleName;
    }

    @Override
    protected void configure() {
        bind(application).to(Application.class);
        bindFactory(new Factory<Module>() {
            @Override
            public Module provide() {
                return application.findModule(layerName, moduleName);
            }

            @Override
            public void dispose(Module instance) {
            }
        }).to(Module.class);
        bindFactory(new Factory<Layer>() {
            @Override
            public Layer provide() {
                return application.findLayer(layerName);
            }

            @Override
            public void dispose(Layer instance) {
            }
        }).to(Layer.class);
        bind(new StructureInjectionResolver(application, layerName, moduleName))
                .to(StructureInjectionResolver.TYPE_LITERAL);
        bind(new ServiceInjectionResolver(application, layerName, moduleName))
                .to(ServiceInjectionResolver.TYPE_LITERAL);
    }

    @Singleton
    public static class StructureInjectionResolver implements
            InjectionResolver<Structure> {
        public static final TypeLiteral<InjectionResolver<Structure>> TYPE_LITERAL;

        static {
            TYPE_LITERAL = new TypeLiteral<InjectionResolver<Structure>>() {
            };
        }
        private final Application application;
        private final String layerName;
        private final String moduleName;

        public StructureInjectionResolver(Application application,
                String layerName, String moduleName) {
            this.application = application;
            this.layerName = layerName;
            this.moduleName = moduleName;
        }

        @Override
        public Object resolve(Injectee injectee, ServiceHandle<?> root) {
            Type type = injectee.getRequiredType();
            if (Application.class.equals(type)) {
                return application;
            }
            if (Layer.class.equals(type)) {
                return application.findLayer(layerName);
            }
            if (Module.class.equals(type)) {
                return application.findModule(layerName, moduleName);
            }
            return null;
        }

        @Override
        public boolean isConstructorParameterIndicator() {
            return false;
        }

        @Override
        public boolean isMethodParameterIndicator() {
            return false;
        }
    }

    @Singleton
    public static class ServiceInjectionResolver implements
            InjectionResolver<Service> {
        public static final TypeLiteral<InjectionResolver<Service>> TYPE_LITERAL;

        static {
            TYPE_LITERAL = new TypeLiteral<InjectionResolver<Service>>() {
            };
        }
        private final Application application;
        private final String layerName;
        private final String moduleName;

        public ServiceInjectionResolver(Application application,
                String layerName, String moduleName) {
            this.application = application;
            this.layerName = layerName;
            this.moduleName = moduleName;
        }

        @Override
        public Object resolve(Injectee injectee, ServiceHandle<?> root) {
            Type type = injectee.getRequiredType();
            Module module = application.findModule(layerName, moduleName);
            try {
                return module.findService(type).get();
            } catch (NoSuchServiceException ex) {
                ex.printStackTrace();
                return null;
            }
        }

        @Override
        public boolean isConstructorParameterIndicator() {
            return false;
        }

        @Override
        public boolean isMethodParameterIndicator() {
            return false;
        }
    }
}
