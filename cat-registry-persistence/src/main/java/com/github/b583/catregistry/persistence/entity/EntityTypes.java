package com.github.b583.catregistry.persistence.entity;

import java.util.List;

public class EntityTypes {

    private EntityTypes() {
    }

    public static List<Class<?>> getEntityTypes() {
        return List.of(CatEntity.class);
    }

}
