package com.epam.bookstore.entity;

import java.util.Objects;

public class Language {

    private Long id;
    private String shortName;
    private String name;

    public Language() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Language language = (Language) o;
        return Objects.equals(id, language.id) &&
                Objects.equals(shortName, language.shortName) &&
                Objects.equals(name, language.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shortName, name);
    }

    @Override
    public String toString() {
        return "Language{" +
                "id=" + id +
                ", shortName='" + shortName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
