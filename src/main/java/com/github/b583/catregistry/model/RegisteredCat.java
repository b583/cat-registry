package com.github.b583.catregistry.model;

import javax.annotation.Nonnull;

public class RegisteredCat extends Cat {

    private final String id;

    public RegisteredCat(@Nonnull String name, @Nonnull String color, @Nonnull Boolean isNice, @Nonnull String id) {
        super(name, color, isNice);
        this.id = id;
    }

    @Nonnull
    public String getId() {
        return id;
    }
}
