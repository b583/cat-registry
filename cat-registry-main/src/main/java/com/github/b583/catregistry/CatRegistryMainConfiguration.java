package com.github.b583.catregistry;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.b583.catregistry.service.CatRegistryServiceConfiguration;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

class CatRegistryMainConfiguration extends Configuration {

    @Valid
    @NotNull
    @JsonProperty
    private CatRegistryServiceConfiguration service;

    @Valid
    @NotNull
    @JsonProperty
    private DataSourceFactory database;

    public CatRegistryServiceConfiguration getCatRegistryServiceConfiguration() {
        return service;
    }

    public DataSourceFactory getDatabase() {
        return database;
    }
}
