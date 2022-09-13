package com.github.b583.catregistry.service;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class CatRegistryServiceConfiguration {

    @NotNull
    @JsonProperty
    private boolean shouldRegisterNotNiceCats;

    boolean isShouldRegisterNotNiceCats() {
        return shouldRegisterNotNiceCats;
    }

}
