package com.github.b583.catregistry;

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
        install(new CatRegistryServiceModule(configuration.getCatRegistryServiceConfiguration()));

        bind(SessionFactory.class).toInstance(sessionFactory);
    }
}
