package com.github.b583.catregistry;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class CatRegistryConfiguration extends Configuration {

    @NotNull
    private boolean shouldRegisterNotNiceCats;

    @Valid
    @NotNull
    private DataSourceFactory database;

    public boolean isShouldRegisterNotNiceCats() {
        return shouldRegisterNotNiceCats;
    }

    public DataSourceFactory getDatabase() {
        return database;
    }
}
