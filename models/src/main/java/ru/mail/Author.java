package ru.mail;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public final class Author {
    private final int id;

    private final @NotNull String name;

    private final @NotNull String country;

    public Author(int id, @NotNull String name, @NotNull String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }
}
