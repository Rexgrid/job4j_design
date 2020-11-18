package ru.job4j.Collections;

public class SimpleStack<T> {
    private final ForwardLinked<T> linked = new ForwardLinked<T>();

    public T pop() {
        return linked.deleteLast();
    }

    public void push(T value) {
    linked.add(value);
    }

    public boolean empty() {
        return linked.isEmpty();
    }
}