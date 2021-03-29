package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> rsl = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
           while (in.read() != -1) {
                String ln = in.readLine() ;
                String[] a = ln.split(" ");
                if (a[a.length - 2].equals("404")) {
                    rsl.add(ln);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    public static void save (List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
           for (String lg : log) {
               out.println(lg);
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        save(log, "404.txt");
        log.forEach(System.out::println);
    }
}