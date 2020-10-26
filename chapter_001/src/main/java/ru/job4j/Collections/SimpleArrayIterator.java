package ru.job4j.Collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayIterator<T> implements Iterator<T> {

    private T[] iter;
    private int cursor = 0;

    public SimpleArrayIterator(T[] obj) {
        this.iter = obj;
    }

    @Override
    public boolean hasNext() {
        return cursor < iter.length;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return iter[cursor++];
    }
}
