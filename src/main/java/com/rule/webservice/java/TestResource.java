package com.rule.webservice.java;


import javax.ws.rs.*;
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
    public String sayHello() throws Exception {
        TranslationService ts = new TranslationService();
        return ts.translate();
    }

    @GET
    @Produces(MediaType.TEXT_XML)
    public String sayXMLHello() {
        return "<?xml version=\"1.0\"?><hello> Hello World XML, YAY!!!</hello>";
    }
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String sayHtmlHello() {
        return "<html><title>Hello World HTML</title><body><h1>Hello World HTML JRebel Rules!</body></h1></html>";
    }

    @POST
    @Consumes({"text/xml", "text/plain", MediaType.TEXT_HTML})
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPostHello() {
        return "Hello World Post!";
    }
}
