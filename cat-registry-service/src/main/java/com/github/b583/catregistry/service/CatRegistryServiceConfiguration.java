package com.github.b583.catregistry.service;

import jakarta.validation.constraints.NotNull;

public class CatRegistryServiceConfiguration {

    @NotNull
    private boolean shouldRegisterNotNiceCats;

    boolean isShouldRegisterNotNiceCats() {
        return shouldRegisterNotNiceCats;
    }

}
