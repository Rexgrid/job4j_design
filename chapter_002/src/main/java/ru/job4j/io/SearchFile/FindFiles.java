package ru.job4j.io.SearchFile;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FindFiles {

    public static void writeInFile(List<Path> searchResult, File output) {
        try (FileOutputStream fos = new FileOutputStream(output);
        PrintStream ps = new PrintStream(fos)){
          for (Path file : searchResult) {
              ps.println(file);
          }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Path> searchOption(String searchArgument, Path start, String fileName) throws IOException {
        List<Path> result = null;
        if (searchArgument.equals("mask")) {
            String subString = fileName.substring(2);
            result = Search.search(start, x -> x.toFile().getName().endsWith(subString));
        } else if (searchArgument.equals("fileName")) {
            result = Search.search(start, x -> x.toFile().getName().equals(fileName));
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        ArgsName argsName = ArgsName.of(args);
        if (argsName.get("o") == null) {
            throw new IllegalArgumentException("Укажите путь к файлу для записи результатов поиска");
        }
        File destination = new File(argsName.get("o"));
        Path start = Paths.get(argsName.get("d"));
        String searchType = argsName.get("t");
        if (!searchType.equals("mask") && !searchType.equals("fileName")) {
           throw new IllegalArgumentException("Введен не правильный параметр поиска");
        }
        writeInFile(searchOption(searchType, start, argsName.get("n")), destination);
    }
}
