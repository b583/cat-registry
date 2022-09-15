package com.github.b583.catregistry;

import com.github.b583.catregistry.api.ApiModule;
import com.github.b583.catregistry.persistence.PersistenceModule;
import com.github.b583.catregistry.service.CatRegistryServiceModule;
import com.google.inject.AbstractModule;
import org.hibernate.SessionFactory;

class MainModule extends AbstractModule {

    private final CatRegistryMainConfiguration configuration;
    private final SessionFactory sessionFactory;

    MainModule(CatRegistryMainConfiguration configuration, SessionFactory sessionFactory) {
        this.configuration = configuration;
        this.sessionFactory = sessionFactory;
    }

    @Override
    protected void configure() {
        install(new PersistenceModule(sessionFactory));
        install(new CatRegistryServiceModule(configuration.getCatRegistryServiceConfiguration()));
        install(new ApiModule());
    }
}
