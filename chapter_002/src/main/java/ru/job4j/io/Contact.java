package ru.job4j.io;

import java.io.*;
import java.nio.*;
import java.nio.file.Files;

public class Contact implements Serializable {

    private String name;
    private int age;

    public Contact(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Contact contact = new Contact("Alex", 28);
        File tempFile = Files.createTempFile(null, null).toFile();
        try (FileOutputStream fos = new FileOutputStream(tempFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(contact);
        }
        try (FileInputStream fis = new FileInputStream(tempFile);
        ObjectInputStream ois = new ObjectInputStream(fis)) {
            Contact contactFromFile = (Contact) ois.readObject();
            System.out.println(contactFromFile);
        }
    }

}
