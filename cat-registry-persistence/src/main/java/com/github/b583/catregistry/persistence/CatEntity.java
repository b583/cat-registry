package com.github.b583.catregistry.persistence;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cat", schema = "cat")
public class CatEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "is_nice", nullable = false)
    private Boolean isNice;

    public CatEntity(Long id, String name, String color, Boolean isNice) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.isNice = isNice;
    }

    protected CatEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public Boolean isNice() {
        return isNice;
    }
}
