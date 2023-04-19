package com.codecampn.quarkus.app.template.business.config;

import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "my-section")
public interface ConfigProperties {

    String myPropOne();
    String myPropTwo();

}
