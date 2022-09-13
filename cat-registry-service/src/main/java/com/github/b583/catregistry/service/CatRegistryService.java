package com.github.b583.catregistry.service;

import com.github.b583.catregistry.model.RegisteredCat;
import com.github.b583.catregistry.model.UnregisteredCat;
import com.github.b583.catregistry.persistence.CatRepository;

import static org.apache.commons.lang3.BooleanUtils.isFalse;

public class CatRegistryService {

    private final CatRepository catRepository;
    private final CatRegistryServiceConfiguration configuration;

    CatRegistryService(CatRepository catRepository, CatRegistryServiceConfiguration configuration) {
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
