package ru.job4j.io;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;


public class Analizy {
    private static List<String> rsl = new ArrayList<>();
    private static String begining;

    public void unavailable(String source) {
        boolean serverStatus = true;
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] lines = line.split(" ");
                if (serverStatus && (lines[0].equals("400") || lines[0].equals("500"))) {
                    begining = lines[1];
                    serverStatus = false;
                } else if (!serverStatus && (lines[0].equals("200") || lines[0].equals("300"))) {
                    begining += ";" + lines[1];
                    rsl.add(begining);
                    serverStatus = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void writeInTarget(String target) throws FileNotFoundException {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(target)
                ))) {
            for (String line: rsl) {
                out.println(line);
            }
        }
    }


    public static void main(String[] args) throws FileNotFoundException {
        Analizy al = new Analizy();
        al.unavailable("unavailable.csv");
        al.writeInTarget("test.csv");
    }
}