package com.github.b583.catregistry;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class CatRegistryConfiguration extends Configuration {

    @NotNull
    private boolean shouldRegisterNotNiceKitties;

    @Valid
    @NotNull
    private DataSourceFactory database;

    public boolean isShouldRegisterNotNiceKitties() {
        return shouldRegisterNotNiceKitties;
    }

    public DataSourceFactory getDatabase() {
        return database;
    }
}
