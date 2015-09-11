package com.chf.example.apache.cxf.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.chf.example.domain.SimplePojo;

@Path("/rest")
public class RestService {

    @GET
    public String index() {
        return "hello cxf";
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public SimplePojo getObject(@PathParam("id") String id) {
        SimplePojo obj = new SimplePojo();
        obj.setStr(id);
        return obj;
    }
}
