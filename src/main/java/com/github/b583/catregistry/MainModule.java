package com.github.b583.catregistry;

import com.google.inject.AbstractModule;
import org.hibernate.SessionFactory;

class MainModule extends AbstractModule {

    private final CatRegistryConfiguration configuration;
    private final SessionFactory sessionFactory;

    MainModule(CatRegistryConfiguration configuration, SessionFactory sessionFactory) {
        this.configuration = configuration;
        this.sessionFactory = sessionFactory;
    }

    @Override
    protected void configure() {
        bind(CatRegistryConfiguration.class).toInstance(configuration);
        bind(SessionFactory.class).toInstance(sessionFactory);
    }
}
