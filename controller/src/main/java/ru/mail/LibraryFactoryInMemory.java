package ru.mail;

import org.jetbrains.annotations.NotNull;
import java.util.List;

public final class LibraryFactoryInMemory implements LibraryFactory{
    private final @NotNull List<Author> authors = List.of(
            new Author(0, "Лев Толстой", "Российская империя"),
            new Author(1, "Александр Пушкин", "Российская империя"),
            new Author(2, "Фёдор Достоевский", "Российская империя")
    );

    private final @NotNull List<Book> books = List.of(
            new Book(0, "Война и мир", 9999999, authors.get(0)),
            new Book(1, "Руслан и Людмила", 140, authors.get(1)),
            new Book(2, "Преступление и наказание", 100, authors.get(2)),
            new Book(1, "Дубровский", 160, authors.get(1))
    );

    @Override
    public Library createLibrary() {
        return new Library(authors, books);
    }
}
