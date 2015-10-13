package com.chf.example.apache.zest.composite;

import org.qi4j.api.injection.scope.State;
import org.qi4j.api.property.Property;

public class PropertyMixin implements MyProperty {

    @State
    private Property<String> name;

    @Override
    public Property<String> name() {
        return name;
    }

}
