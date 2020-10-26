package ru.job4j.Collections;

import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {

    private T[] listModel;
    private int index;

    public SimpleArray(T[] listModel) {
        this.listModel = listModel;
        this.index = 0;
    }

    public T add(T model) {
        while (iterator().hasNext()) {
             if (listModel[index] == null) {
                listModel[index] = model;
                break;
            }
             index++;
        }
        index = 0;
        return model;
    }

    public T set(int index, T model) {
        Objects.checkIndex(index, listModel.length);
       listModel[index] = model;
        return (T) listModel;
    }

    public void remove(int index) {
        Objects.checkIndex(index, listModel.length);
        final int newSize;
        if ((newSize = listModel.length - 1) > index)
            System.arraycopy(listModel, index + 1, listModel, index, newSize - index);
        listModel[newSize] = null;

    }

    public T get(int index) {
        Objects.checkIndex(index, listModel.length);
        return listModel[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleArrayIterator<>(listModel);
    }
}


