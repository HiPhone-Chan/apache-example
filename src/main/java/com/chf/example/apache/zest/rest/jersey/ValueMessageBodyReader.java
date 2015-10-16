package com.chf.example.apache.zest.rest.jersey;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;

import org.qi4j.api.structure.Application;
import org.qi4j.api.structure.Module;
import org.qi4j.api.value.ValueDeserializer;

public class ValueMessageBodyReader implements MessageBodyReader<Object> {

    private final Module module;

    public ValueMessageBodyReader(Application application, String layerName,
            String moduleName) {
        module = application.findModule(layerName, moduleName);
    }

    @Override
    public boolean isReadable(Class<?> type, Type genericType,
            Annotation[] annotations, MediaType mediaType) {
        return ValueMessageBodyUtils.findValueType(module, type) != null;
    }

    @Override
    public Object readFrom(Class<Object> type, Type genericType,
            Annotation[] annotations, MediaType mediaType,
            MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
            throws IOException, WebApplicationException {
        ValueDeserializer deserializer = module.findService(
                ValueDeserializer.class).get();
        return deserializer.deserialize(type, entityStream);
    }
}
