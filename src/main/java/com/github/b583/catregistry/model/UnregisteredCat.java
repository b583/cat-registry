package com.github.b583.catregistry.model;

import javax.annotation.Nonnull;

public class UnregisteredCat extends Cat {

    public UnregisteredCat(@Nonnull String name, @Nonnull String color, @Nonnull Boolean isNice) {
        super(name, color, isNice);
    }
}
