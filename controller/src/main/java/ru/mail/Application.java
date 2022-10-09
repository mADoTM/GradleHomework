package ru.mail;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jetbrains.annotations.NotNull;
import ru.mail.utils.FileUtils;

import java.util.List;

public final class Application {
    private final static @NotNull Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void main(@NotNull String[] args){
        String flag = args[0];

        LibraryFactory factory;
        Library library;
        String authorName;

        if(flag.equals("-f")) {
            factory = new LibraryFactoryFromFile(args[1], args[2]);
            authorName = FileUtils.getRussianText(args[3]);
        }
        else {
            factory = new LibraryFactoryInMemory();
            authorName = FileUtils.getRussianText(args[1]);
        }

        library = factory.createLibrary();

        var books = library.getBooksByName(authorName);

        printBooks(books);
    }

    public static void printBooks(List<Book> books) {
        String jsonOutput = gson.toJson(books);

        System.out.println(jsonOutput);
    }
}
