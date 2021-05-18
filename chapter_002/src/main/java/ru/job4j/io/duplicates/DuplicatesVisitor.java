package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private Map<String, Long> fp = new HashMap<>();
    private List<FileProperty> duplicates = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty pr = new FileProperty(file.toFile().length(), file.toFile().getName());
        if (fp.containsKey(pr.getName()) && fp.containsValue(pr.getSize()))
        {
            System.out.println("Найден дубликат файла "+ file.toFile().getName() +" : дубликат находится в директории " + file.toAbsolutePath());
        }
        fp.put(pr.getName(), pr.getSize());
        return super.visitFile(file, attrs);
    }
}
