package ru.job4j.io.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class Person {
    private final boolean sex;
    private final int weight;
    private final Device device;
    private final String[] family;

    public Person(boolean sex, int weight, Device device, String... family) {
        this.sex = sex;
        this.weight = weight;
        this.device = device;
        this.family = family;
    }

    @Override
    public String toString() {
        return "Person{"
                + "sex=" + sex
                + ", weight=" + weight
                + ", device=" + device
                + ", family=" + Arrays.toString(family)
                + '}';
    }

    public static void main(String[] args) {
        final Person person = new Person(true, 86, new Device("laptop"), "Dad", "Mom");


        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(person));


        final String personJson =
                "{"
                        + "\"sex\":true,"
                        + "\"weight\":86,"
                        + "\"device\":"
                        + "{"
                        + "\"Device\":\"laptop\""
                        + "},"
                        + "\"family\":"
                        + "[\"Dad\",\"Mom\"]"
                        + "}";
        final Person personMod = gson.fromJson(personJson, Person.class);
        System.out.println(personMod);

    }
}
