package com.rule.webservice.java;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Document me please
 * User: wfijarczyk
 * Date: 13.01.14
 */
@Path("/testwebservice")
public class TestResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello(){
        return "Hello this is simple string";
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String sayHtmlHello() {
        return "<html><title>Hello World HTML</title><body><h1>Hello World HTML JRebel Rules!</body></h1></html>";
    }

}
