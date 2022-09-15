package com.github.b583.catregistry.persistence;

import com.github.b583.catregistry.persistence.entity.AnEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import java.util.function.Function;
import java.util.function.Supplier;

import static java.util.Objects.isNull;

abstract class AbstractRepository<E extends AnEntity> {

    private static final ThreadLocal<EntityManager> entityManagerContext = new ThreadLocal<>();

    final EntityManagerFactory entityManagerFactory;
    private final Class<E> clazz;

    AbstractRepository(EntityManagerFactory entityManagerFactory, Class<E> clazz) {
        this.entityManagerFactory = entityManagerFactory;
        this.clazz = clazz;
    }

    private void createEntityManager() {
        entityManagerContext.set(entityManagerFactory.createEntityManager());
    }

    private EntityManager getEntityManager() {
        var entityManager = entityManagerContext.get();
        if (isNull(entityManager)) {
            throw new PersistenceException("Unexpectedly EntityManager is null. Did you wrap your code in executeInSession(Supplier<R>)?");
        }
        if (!entityManager.isOpen()) {
            throw new PersistenceException("Unexpectedly EntityManager is closed.");
        }
        return entityManager;
    }

    private void removeEntityManager() {
        entityManagerContext.remove();
    }

    public <R> R executeInSession(Supplier<R> supplier) {
        try {
            createEntityManager();
            return supplier.get();
        } catch (Exception e) {
            removeEntityManager();
            throw e;
        }
    }

    private <R> R execute(Function<EntityManager, R> function) {
        try {
            return function.apply(getEntityManager());
        } catch (Exception e) {
            removeEntityManager();
            throw e;
        }
    }

    E persist(E t) {
        return execute(em -> {
            final var transaction = em.getTransaction();
            final var isSingleOperationTransaction = !transaction.isActive();

            if (isSingleOperationTransaction) {
                transaction.begin();
            }

            em.persist(t);

            if (isSingleOperationTransaction) {
                transaction.commit();
            }

            return em.find(clazz, t.getId());
        });
    }

}
