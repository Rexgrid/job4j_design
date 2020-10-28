package ru.job4j.Collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {

    private T[] listModel;
    private int size;
    private int cells;

    public SimpleArray(int cells) {
        this.size = 0;
        this.cells = cells;
        this.listModel = (T[]) new Object[cells];
            }

    public T add(T model) {
        if(size >= listModel.length) {
            throw new IndexOutOfBoundsException();
        } else {
            listModel[size] = model;
            size++;
        }
        return model;
    }

    public T set(int index, T model) {
        Objects.checkIndex(index, size);
       listModel[index] = model;
        return (T) listModel;
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);
        T[] newSize = (T[]) new Object[listModel.length-1];
            System.arraycopy(listModel, index + 1, newSize, index, newSize.length);
    }

    public T get(int index) {
        Objects.checkIndex(index, listModel.length);
        return listModel[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return listModel[cursor++];
            }
        };
    }
}


