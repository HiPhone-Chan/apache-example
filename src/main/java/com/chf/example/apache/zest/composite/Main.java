package com.chf.example.apache.zest.composite;

import org.qi4j.bootstrap.AssemblyException;
import org.qi4j.bootstrap.ModuleAssembly;
import org.qi4j.bootstrap.SingletonAssembler;

public class Main {

    public static void main(String[] args) throws Exception {
        SingletonAssembler assembler = new SingletonAssembler() {
            @Override
            public void assemble(ModuleAssembly assembly)
                    throws AssemblyException {
                assembly.transients(SpeakerComposite.class);
            }
        };

        SpeakerComposite speaker = assembler.module().newTransient(
                SpeakerComposite.class);
        speaker.name().set("c");
        System.out.println(speaker.sayHello());

    }
}
