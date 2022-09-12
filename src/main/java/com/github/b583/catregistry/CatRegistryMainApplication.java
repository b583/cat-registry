package com.github.b583.catregistry;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class CatRegistryMainApplication extends Application<CatRegistryConfiguration> {

    public static void main(String[] args) throws Exception {
        new CatRegistryMainApplication().run(args);
    }

    @Override
    public void run(CatRegistryConfiguration catRegistryConfiguration, Environment environment) {
        // to be implemented
    }
}
