package ru.job4j.Collections;

import java.util.HashSet;
import java.util.Iterator;

public class SimpleSet<T> implements Iterable<T> {

    private final SimplyArray<T> simArr;
    private int size;

    public SimpleSet() {
        this.simArr = new SimplyArray<>();
        this.size = 0;
    }

    public void add(T e) {
        if (size == 0) {
            simArr.add(e);
            size++;
        }
        for (int i = 0; i < size; i++) {
            if (simArr.get(i) == e) {
                return;
            } else {
                simArr.add(e);
                size++;
            }
        }

    }

    @Override
    public Iterator<T> iterator() {
        return simArr.iterator();
    }
}
