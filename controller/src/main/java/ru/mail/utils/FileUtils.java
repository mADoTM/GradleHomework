package ru.mail.utils;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileUtils {
    public static @NotNull List<String> getFileLines(@NotNull String filePath){
        try {
            return Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getRussianText(String badText){
        byte[] bytes = badText.getBytes(StandardCharsets.UTF_8);
        try {
            return new String(bytes, "Windows-1251");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
