package com.github.b583.catregistry;

import com.google.inject.AbstractModule;
import org.hibernate.SessionFactory;

class MainModule extends AbstractModule {

    private final SessionFactory sessionFactory;

    MainModule(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    protected void configure() {
        bind(SessionFactory.class).toInstance(sessionFactory);
    }
}
