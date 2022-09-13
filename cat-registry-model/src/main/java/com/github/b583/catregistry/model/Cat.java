package com.github.b583.catregistry.model;

import javax.annotation.Nonnull;

public class Cat {

    private final String name;
    private final String color;
    private final Boolean isNice;

    Cat(@Nonnull String name, @Nonnull String color, @Nonnull Boolean isNice) {
        this.name = name;
        this.color = color;
        this.isNice = isNice;
    }

    @Nonnull
    public String getName() {
        return name;
    }

    @Nonnull
    public String getColor() {
        return color;
    }

    @Nonnull
    public Boolean isNice() {
        return isNice;
    }
}
