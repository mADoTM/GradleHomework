package ru.mail;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public final class Book {
    private final int id;

    private final @NotNull String name;

    private final int pagesCount;

    private final Author author;

    public Book(int id, @NotNull String name, int pagesCount,  Author author) {
        this.id = id;
        this.name = name;
        this.pagesCount = pagesCount;
        this.author = author;
    }
}
