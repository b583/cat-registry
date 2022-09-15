package com.github.b583.catregistry.persistence;

import com.github.b583.catregistry.model.RegisteredCat;
import com.github.b583.catregistry.model.UnregisteredCat;
import com.github.b583.catregistry.persistence.entity.CatEntity;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import javax.persistence.EntityManagerFactory;

@Singleton
public class CatRepository extends AbstractRepository<CatEntity> {

    @Inject
    CatRepository(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory, CatEntity.class);
    }

    public RegisteredCat save(UnregisteredCat unregisteredCat) {
        final var catEntity = toCatEntity(unregisteredCat);
        final var savedCatEntity = executeInSession(() -> persist(catEntity));
        return toRegisteredCat(savedCatEntity);
    }

    private CatEntity toCatEntity(UnregisteredCat unregisteredCat) {
        return new CatEntity(null, unregisteredCat.getName(), unregisteredCat.getColor(), unregisteredCat.isNice());
    }

    private RegisteredCat toRegisteredCat(CatEntity catEntity) {
        return new RegisteredCat(catEntity.getId(), catEntity.getName(), catEntity.getColor(), catEntity.isNice());
    }

}
