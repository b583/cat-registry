package com.github.b583.catregistry;

import com.github.b583.catregistry.api.CatRegistryResource;
import com.github.b583.catregistry.api.NotNiceCatExceptionMapper;
import com.github.b583.catregistry.persistence.entity.CatEntity;
import com.google.inject.Guice;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class CatRegistryMainApplication extends Application<CatRegistryConfiguration> {

    private final HibernateBundle<CatRegistryConfiguration> hibernateBundle = new HibernateBundle<>(CatEntity.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(CatRegistryConfiguration configuration) {
            return configuration.getDatabase();
        }
    };

    public static void main(String[] args) throws Exception {
        new CatRegistryMainApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<CatRegistryConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
    }

    @Override
    public void run(CatRegistryConfiguration catRegistryConfiguration, Environment environment) {
        final var injector = Guice.createInjector(
                new MainModule(catRegistryConfiguration, hibernateBundle.getSessionFactory()));

        environment.jersey().register(injector.getInstance(CatRegistryResource.class));
        environment.jersey().register(injector.getInstance(NotNiceCatExceptionMapper.class));
    }
}
