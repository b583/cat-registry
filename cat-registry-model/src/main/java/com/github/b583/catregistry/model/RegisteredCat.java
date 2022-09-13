package com.github.b583.catregistry.model;

import javax.annotation.Nonnull;

public class RegisteredCat extends Cat {

    private final Long id;

    public RegisteredCat(@Nonnull Long id, @Nonnull String name, @Nonnull String color, @Nonnull Boolean isNice) {
        super(name, color, isNice);
        this.id = id;
    }

    @Nonnull
    public Long getId() {
        return id;
    }
}
