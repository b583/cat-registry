package com.github.b583.catregistry;

import com.github.b583.catregistry.api.WebResource;
import com.github.b583.catregistry.persistence.entity.EntityTypes;
import com.google.inject.Guice;
import com.google.inject.Key;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.hibernate.SessionFactoryFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.util.Set;

class CatRegistryMainApplication extends Application<CatRegistryMainConfiguration> {

    private final HibernateBundle<CatRegistryMainConfiguration> hibernateBundle =
            new HibernateBundle<>(EntityTypes.getEntityTypes(), new SessionFactoryFactory()) {
        @Override
        public DataSourceFactory getDataSourceFactory(CatRegistryMainConfiguration configuration) {
            return configuration.getDatabase();
        }
    };

    public static void main(String[] args) throws Exception {
        new CatRegistryMainApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<CatRegistryMainConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
    }

    @Override
    public void run(CatRegistryMainConfiguration catRegistryMainConfiguration, Environment environment) {
        final var injector = Guice.createInjector(
                new MainModule(catRegistryMainConfiguration, hibernateBundle.getSessionFactory()));

        injector.getInstance(new Key<Set<WebResource>>() {}).forEach(webResource -> environment.jersey().register(webResource));
    }
}
