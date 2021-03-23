package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("Multiple.txt")) {
            for (int i = 1; i < 10; i++) {
               int rsl = 1 * i;
               String toWrite = rsl + " ";
                out.write(toWrite.getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}