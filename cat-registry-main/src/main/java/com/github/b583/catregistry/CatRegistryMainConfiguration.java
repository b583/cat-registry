package com.github.b583.catregistry;

import com.github.b583.catregistry.service.CatRegistryServiceConfiguration;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

class CatRegistryMainConfiguration extends Configuration {

    @Valid
    @NotNull
    private CatRegistryServiceConfiguration service;

    @Valid
    @NotNull
    private DataSourceFactory database;

    public CatRegistryServiceConfiguration getCatRegistryServiceConfiguration() {
        return service;
    }

    public DataSourceFactory getDatabase() {
        return database;
    }
}
