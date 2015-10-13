package com.chf.example.apache.zest.assemble;

import org.qi4j.api.common.Visibility;
import org.qi4j.bootstrap.ApplicationAssembler;
import org.qi4j.bootstrap.ApplicationAssembly;
import org.qi4j.bootstrap.ApplicationAssemblyFactory;
import org.qi4j.bootstrap.AssemblyException;
import org.qi4j.bootstrap.LayerAssembly;
import org.qi4j.bootstrap.ModuleAssembly;

import com.chf.example.apache.zest.composite.Speaker;

public class MyApplicationAssembler implements ApplicationAssembler {

    @Override
    public ApplicationAssembly assemble(
            ApplicationAssemblyFactory applicationFactory)
            throws AssemblyException {

        ApplicationAssembly assembly = applicationFactory
                .newApplicationAssembly();
        assembly.setName("My Application");

        LayerAssembly layer1 = assembly.layer("My Layer1");
        ModuleAssembly module1 = layer1.module("My Module1");
        module1.transients(Speaker.class).visibleIn(Visibility.application);

        layer1.module("My Module2");

        LayerAssembly layer2 = assembly.layer("My Layer2");
        layer2.module("My Module3");

        layer2.uses(layer1);

        return assembly;
    }

}
