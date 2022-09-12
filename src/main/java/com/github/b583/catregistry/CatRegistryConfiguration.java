package com.github.b583.catregistry;

import io.dropwizard.Configuration;

import javax.validation.constraints.NotNull;

public class CatRegistryConfiguration extends Configuration {

    @NotNull
    private boolean shouldRegisterNotNiceKitties;

    public boolean isShouldRegisterNotNiceKitties() {
        return shouldRegisterNotNiceKitties;
    }
}
