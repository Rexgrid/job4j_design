package ru.job4j.Collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Iterable<T> {

    private final SimplyArray<T> simArr;
    private int size;

    public SimpleSet() {
        this.simArr = new SimplyArray<>();
        this.size = 0;
    }

    public void add(T e) {
        if (size == 0 || !contain(e)) {
            simArr.add(e);
            size++;
        }
    }

    public boolean contain(T e) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(simArr.get(i),e)) {
                return true;
            }
        }
        return false;
    }

        @Override
        public Iterator<T> iterator () {
            return simArr.iterator();
        }
    }
