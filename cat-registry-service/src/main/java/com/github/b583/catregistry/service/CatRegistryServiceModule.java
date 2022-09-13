package com.github.b583.catregistry.service;

import com.github.b583.catregistry.persistence.CatRepository;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

public class CatRegistryServiceModule extends AbstractModule {

    private final CatRegistryServiceConfiguration configuration;

    public CatRegistryServiceModule(CatRegistryServiceConfiguration configuration) {
        this.configuration = configuration;
    }

    @Provides
    @Singleton
    CatRegistryService getCatRegistryService(CatRepository catRepository) {
        return new CatRegistryService(catRepository, configuration);
    }

}
