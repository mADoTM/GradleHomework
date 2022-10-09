package ru.mail;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public final class Library {
    public final @NotNull List<Author> authors;
    public final @NotNull List<Book> books;

    public Library(@NotNull List<Author> authors, @NotNull List<Book> books) {
        this.authors = authors;
        this.books = books;
    }

    public List<Book> getBooksByName(@NotNull String name) {
        return books.stream().filter(book -> book.getAuthor().getName().equals(name)).collect(Collectors.toList());
    }
}
