package com.github.b583.catregistry.api;

import com.github.b583.catregistry.api.resource.CatRegistryResource;
import com.github.b583.catregistry.api.resource.NotNiceCatExceptionMapper;
import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

public class ApiModule extends AbstractModule {

    @Override
    protected void configure() {
        final var mb = Multibinder.newSetBinder(binder(), WebResource.class);
        mb.addBinding().to(CatRegistryResource.class);
        mb.addBinding().to(NotNiceCatExceptionMapper.class);
    }
}
