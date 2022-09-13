package com.github.b583.catregistry.service;

import com.github.b583.catregistry.CatRegistryConfiguration;
import com.github.b583.catregistry.model.RegisteredCat;
import com.github.b583.catregistry.model.UnregisteredCat;
import com.github.b583.catregistry.persistence.CatRepository;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import static org.apache.commons.lang3.BooleanUtils.isFalse;

@Singleton
public class CatRegistryService {

    private final CatRepository catRepository;
    private final CatRegistryConfiguration configuration;

    @Inject
    CatRegistryService(CatRepository catRepository, CatRegistryConfiguration configuration) {
        this.catRepository = catRepository;
        this.configuration = configuration;
    }

    public RegisteredCat registerCat(UnregisteredCat unregisteredCat) {
        if (isFalse(configuration.isShouldRegisterNotNiceCats()) && isFalse(unregisteredCat.isNice())) {
            throw new NotNiceCatException();
        }

        return catRepository.save(unregisteredCat);
    }

}
