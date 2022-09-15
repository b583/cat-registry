package com.github.b583.catregistry.persistence;

import com.google.inject.AbstractModule;

import javax.persistence.EntityManagerFactory;

public class PersistenceModule extends AbstractModule {

    private final EntityManagerFactory entityManagerFactory;

    public PersistenceModule(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    protected void configure() {
        bind(EntityManagerFactory.class).toInstance(entityManagerFactory);
    }
}
