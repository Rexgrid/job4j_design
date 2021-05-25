package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }

    private void parse(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Arguments not found. Please enter the arguments.");
        }
        for (String arg : args) {
            if (arg.startsWith("-")) {
                String tmp = arg.substring(1);
                String[] keyValueSplitter = tmp.split("=");
                if (keyValueSplitter.length < 2) {
                    throw new IllegalArgumentException("Arguments isn't correct. Please check the arguments.");
                }
                values.put(keyValueSplitter[0], keyValueSplitter[1]);
            }
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[]{"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[]{"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}