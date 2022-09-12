package com.github.b583.catregistry.service;

import com.github.b583.catregistry.model.RegisteredCat;
import com.github.b583.catregistry.model.UnregisteredCat;
import com.github.b583.catregistry.persistence.CatRepository;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.dropwizard.hibernate.UnitOfWork;

@Singleton
public class CatRegistryService {

    private final CatRepository catRepository;

    @Inject
    CatRegistryService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    public RegisteredCat registerCat(UnregisteredCat unregisteredCat) {
        return catRepository.save(unregisteredCat);
    }

}
