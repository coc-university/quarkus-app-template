package com.codecampn.quarkus.app.template.api.controller;

import com.codecampn.quarkus.app.template.business.config.ConfigProperties;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
@RequiredArgsConstructor
public class HelloController {

    private final ConfigProperties configProperties;

    @ConfigProperty(name = "my-section.my-prop-two")
    String myPropTwoDirectly;

    @GET
    @Path("/plain")
    @Produces(MediaType.TEXT_PLAIN)
    public String getPlainText() {
        return "Hello plain text";
    }

    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return "Hello json";
    }

    @GET
    @Path("/prop")
    @Produces(MediaType.APPLICATION_JSON)
    public String getProps() {
        return configProperties.myPropOne() + ", " +  myPropTwoDirectly;
    }

}