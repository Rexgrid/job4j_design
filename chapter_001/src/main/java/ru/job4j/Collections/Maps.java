package ru.job4j.Collections;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Maps<K, V> implements Iterable<K> {

    private Data<K, V>[] dataTable;
    private int count = 0;
    private int capacity = 16;
    private int size = 0;
    private double threshold;
    private final double LOAD_FACTOR = 0.6;

    public Maps() {
        dataTable = new Data[capacity];
        threshold = capacity * LOAD_FACTOR;
    }

    public int indexOf(int h, int capacity) {
        return h % capacity;
    }

    public int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    public int getCapacity() {
        return capacity;
    }

    public V get(K key) {
        V result = null;
        Data<K, V> elem = getElem(key);
        if (elem.getKey().equals(key)) {
            result = elem.getValue();
        }
        return result;
    }

    void addEntry(int hash, K key, V value, int index) {
        dataTable[index] = new Data<>(hash, key, value);
    }

    public Data<K, V> getElem(K key) {
        return dataTable[indexOf(hash(key.hashCode()), dataTable.length)];
    }

    boolean delete(K key) {
        boolean result = false;
        int ind = indexOf(hash(key.hashCode()), dataTable.length);
        if (getElem(key) != null) {
            if (dataTable[ind].getKey().equals(key)) {
                dataTable[ind] = null;
                size--;
                count++;
                result = true;
            }
        }
        return result;
    }

    void resizeTable() {
        Data<K, V>[] temp = dataTable;
        dataTable = new Data[capacity];
        threshold = capacity * LOAD_FACTOR;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != null) {
                int h = hash((temp[i].getKey()).hashCode());
                int ind = indexOf(h, capacity);
                dataTable[ind] = temp[i];
            } else {
                i++;
            }
        }
    }

    boolean insert(K key, V value) {
        boolean rsl = false;
        if (getElem(key) == null) {
            int h = hash(key.hashCode());
            int i = indexOf(h, dataTable.length);
            if (size < threshold) {
                addEntry(h, key, value, i);
                size++;
            } else if (capacity > threshold) {
                capacity = capacity * 2;
                resizeTable();
            }
            count++;
            rsl = true;
        }
        return rsl;
    }


    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int cursor = 0;
            private final int modCount = count;

            @Override
            public boolean hasNext() {
                boolean rsl = false;
                while (cursor < capacity) {
                    if (dataTable[cursor] == null) {
                        cursor++;
                    }
                    rsl = true;
                }
                return rsl;
            }

            @Override
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (modCount < count) {
                    throw new ConcurrentModificationException();
                }
                return dataTable[cursor++];
            }
        };
    }


}
