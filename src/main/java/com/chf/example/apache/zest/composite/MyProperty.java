package com.chf.example.apache.zest.composite;

import org.qi4j.api.common.Optional;
import org.qi4j.api.property.Property;
import org.qi4j.library.constraints.annotation.NotEmpty;

public interface MyProperty {

    @Optional
    @NotEmpty
    Property<String> name();
}
