package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path item : sources) {
                if (item.toFile().isDirectory()) {
                   addDirectory(zip, item, target);
                }
                packSingleFile(item.toFile(),target);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   public void addDirectory(ZipOutputStream zout, Path dir, File target) {
        File[] nd = dir.toFile().listFiles();
       for (File itm : nd) {
           if (itm.isDirectory()) {
               addDirectory(zout, itm.toPath(), target);
               continue;
           }
           packSingleFile(itm, target);
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
        Path startArg = Paths.get(argsName.get("d"));
        String excludes = argsName.get("e");
        List<Path> start = Search.search(startArg, x -> x.toFile().getName().endsWith(excludes));
        File out = new File(argsName.get("o"));
        new Zip().packFiles(start,out);
    }
}