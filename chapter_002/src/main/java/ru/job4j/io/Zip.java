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
                   addToZip(zip, item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   public void addToZip(ZipOutputStream zout, Path dir) throws IOException {
        File[] nd = dir.toFile().listFiles();
       for (File itm : nd) {
           if (itm.isDirectory()) {
               addToZip(zout, itm.toPath());
               continue;
           }
            zout.putNextEntry(new ZipEntry(itm.getPath()));
           try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(itm))) {
               zout.write(out.readAllBytes());
           }
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