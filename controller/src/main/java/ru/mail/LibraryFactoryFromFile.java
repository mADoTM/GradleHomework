package ru.mail;

import org.jetbrains.annotations.NotNull;
import ru.mail.utils.FileUtils;

import java.util.ArrayList;
import java.util.List;

public final class LibraryFactoryFromFile implements LibraryFactory {
    private final @NotNull String authorsFilePath;

    private final @NotNull String booksFilePath;

    public LibraryFactoryFromFile(@NotNull String authorsFilePath,
                                  @NotNull String booksFilePath) {
        this.authorsFilePath = authorsFilePath;
        this.booksFilePath = booksFilePath;
    }

    @Override
    public Library createLibrary() {
        final var authors = serializeStringsToAuthors(readFile(authorsFilePath));
        final var books = serializeStringToBooks(readFile(booksFilePath), authors);

        return new Library(authors, books);
    }

    private @NotNull List<String> readFile(@NotNull String filePath) {
        return FileUtils.getFileLines(filePath);
    }

    private @NotNull List<Author> serializeStringsToAuthors(@NotNull List<String> lines) {
        List<Author> authors = new ArrayList<>();
        for(String line : lines) {
            String[] details = line.split("::");

            if(details.length < 3) {
                throw new IllegalArgumentException();
            }

            int authorId = Integer.parseInt(details[0]);
            String name = FileUtils.getRussianText(details[1]);
            String country = FileUtils.getRussianText(details[2]);

            authors.add(new Author(authorId, name, country));
        }

        return authors;
    }

    private @NotNull List<Book> serializeStringToBooks(@NotNull List<String> lines,
                                                       @NotNull List<Author> authors) {
        List<Book> books = new ArrayList<>();
        for(String line : lines) {
            String[] details = line.split("::");

            if(details.length < 4) {
                throw new IllegalArgumentException();
            }

            int bookId = Integer.parseInt(details[0]);
            String name = FileUtils.getRussianText(details[1]);
            int pagesCount = Integer.parseInt(details[2]);
            int authorId = Integer.parseInt(details[3]);

            Author author = authors.stream()
                            .filter(a -> a.getId() == authorId)
                            .findFirst()
                            .orElse(null);

            books.add(new Book(bookId, name, pagesCount, author));
        }

        return books;
    }
}
