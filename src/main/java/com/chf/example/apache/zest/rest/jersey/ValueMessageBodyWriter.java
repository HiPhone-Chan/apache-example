package com.chf.example.apache.zest.rest.jersey;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;

import org.qi4j.api.structure.Application;
import org.qi4j.api.structure.Module;
import org.qi4j.api.value.ValueSerializer;

public class ValueMessageBodyWriter implements MessageBodyWriter<Object> {

    private final Module module;

    public ValueMessageBodyWriter(Application application, String layerName,
            String moduleName) {
        module = application.findModule(layerName, moduleName);
    }

    @Override
    public boolean isWriteable(Class<?> type, Type genericType,
            Annotation[] annotations, MediaType mediaType) {
        return ValueMessageBodyUtils.findValueType(module, type) != null;
    }

    @Override
    public long getSize(Object value, Class<?> type, Type genericType,
            Annotation[] annotations, MediaType mediaType) {

        ValueSerializer serializer = module.findService(ValueSerializer.class)
                .get();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        serializer.serialize(value, baos);
        long size = baos.toByteArray().length;
        return size;
    }

    @Override
    public void writeTo(Object value, Class<?> type, Type genericType,
            Annotation[] annotations, MediaType mediaType,
            MultivaluedMap<String, Object> httpHeaders,
            OutputStream entityStream) throws IOException,
            WebApplicationException {

        ValueSerializer serializer = module.findService(ValueSerializer.class)
                .get();
        serializer.serialize(value, entityStream);
    }
}
