package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path item : sources) {
                  zip.putNextEntry(new ZipEntry(item.toFile().getPath()));
                  try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(item.toFile()))){
                    zip.write(out.readAllBytes());
                  }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ArgsName argsName = ArgsName.of(args);
        Path startArg = Path.of(argsName.get("d"));
        String excludes = argsName.get("e");
        List<Path> start = Search.search(startArg, x -> !x.toFile().getName().endsWith(excludes));
        File out = new File(argsName.get("o"));
        new Zip().packFiles(start,out);
    }
}