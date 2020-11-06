package ru.job4j.Collections;

import java.util.*;

public class SimplyArray<T> implements Iterable<T> {

    Object [] array;
    int modCount;
    int size;

    public SimplyArray() {
        this.array = new Object[10];
        this.modCount = 0;
        this.size = 0;
    }


    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) array[index];
    }

    public void add(T model) {
        modCount++;
        if (size == array.length) {
            int newSize = array.length * 2;
            array = Arrays.copyOf(array, newSize);
        }
            array[size] = model;
            size++;
        }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {

            int cursor;
            final int currentModCount = modCount;

            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
            public T next() {
                if(!hasNext()){
                    throw new NoSuchElementException();
                } else if (currentModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return (T) array[cursor++];
            }
        };
    }
}