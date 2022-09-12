package com.github.b583.catregistry.service;

import com.github.b583.catregistry.CatRegistryConfiguration;
import com.github.b583.catregistry.model.RegisteredCat;
import com.github.b583.catregistry.model.UnregisteredCat;
import com.github.b583.catregistry.persistence.CatRepository;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.apache.commons.lang3.BooleanUtils;

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
        if (isFalse(configuration.isShouldRegisterNotNiceKitties()) && isFalse(unregisteredCat.isNice())) {
            // TODO handle exception so something more elegant than HTTP 500 is returned
            throw new NotNiceKittyException();
        }

        return catRepository.save(unregisteredCat);
    }

}
