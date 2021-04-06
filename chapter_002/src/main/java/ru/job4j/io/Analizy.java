package ru.job4j.io;


import java.io.*;
import java.util.*;


public class Analizy {
    public void unavailable(String source, String target) {
        int innerCount = 0;
        List<String> rsl = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            while (in.read() != -1) {
                String line = in.readLine();
                String[] lines = line.split(" ");
                if (lines[0].equals("400") || lines[0].equals("500")) {
                    rsl.add(lines[1]);
                    innerCount++;
                } else if (innerCount != 0 && lines[0].length() > 0) {
                    rsl.add(lines[1]);
                    innerCount = 0;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(target)
                ))) {
            for (String i : rsl) {
                out.printf("%s;", i);
            }
        } catch (Exception a) {
            a.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy al = new Analizy();
        al.unavailable("unavailable.csv", "test.csv");
    }
}