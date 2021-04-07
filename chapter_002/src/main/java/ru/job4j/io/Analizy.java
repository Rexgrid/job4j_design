package ru.job4j.io;


import java.io.*;
import java.util.*;


public class Analizy {
    private static List<String> rsl = new ArrayList<>();

    public void unavailable(String source) {
        boolean serverStatus = true;
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            while (in.read() != -1) {
                String line = in.readLine();
                String[] lines = line.split(" ");
                if (serverStatus && lines[0].equals("400") || lines[0].equals("500")) {
                    rsl.add(lines[1]);
                    serverStatus = false;
                } else if (!serverStatus && lines[0].equals("200") || lines[0].equals("300")) {
                    rsl.add(lines[1]);
                    serverStatus = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void writeInTarget(String target) {
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
            al.unavailable("unavailable.csv");
            al.writeInTarget("test.csv");
        }
    }