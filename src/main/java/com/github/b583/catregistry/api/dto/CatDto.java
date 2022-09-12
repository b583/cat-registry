package com.github.b583.catregistry.api.dto;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CatDto {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String color;

    @NotNull
    private Boolean isNice;

    public CatDto(@Nullable Long id, @Nonnull String name, @Nonnull String color, @Nonnull Boolean isNice) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.isNice = isNice;
    }

    private CatDto() {
        // for deserialization
    }

    @Nullable
    public Long getId() {
        return id;
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
    public Boolean getIsNice() {
        return isNice;
    }
}
