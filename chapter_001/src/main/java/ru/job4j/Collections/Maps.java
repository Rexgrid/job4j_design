package ru.job4j.Collections;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Maps<K, V > implements Iterable{

    private Data<K, V>[] dataTable;
    private int count = 0;
    private int capacity = 16;
    private int size = 0;
    private double loadFactor = capacity * 0.6;

    public Maps() {
        dataTable = new Data[capacity];
    }

    public int indexOf(int h, int capacity) {
        return h % capacity;
    }

    public int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    public int getCapacity(){
        return capacity;
    }

    public V get(K key) {
        return getElem(key).getValue();
    }

    void addEntry(int hash, K key, V value, int index) {
        dataTable[index] = new Data<>(hash, key, value);
    }

    public Data<K, V> getElem(K key) {
        return dataTable[indexOf(hash(key.hashCode()), dataTable.length)];
    }

    boolean delete(K key) {
        boolean result = false;
        if (getElem(key) != null) {
            if (dataTable[indexOf(hash(key.hashCode()), dataTable.length)].getKey().equals(key)) {
                dataTable[indexOf(hash(key.hashCode()), dataTable.length)] = null;
                size--;
                count++;
                result = true;
            }
        }
        return result;
    }

    void resizeTable() {
        Data<K,V>[] temp = dataTable;
        dataTable = new Data[capacity];
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
            if (size < loadFactor) {
                addEntry(h, key, value, i);
                size++;
            } else if (capacity > loadFactor) {
                capacity = capacity*2;
                resizeTable();
                size = 0;
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
               if (cursor < capacity) rsl = true;
               return rsl;
            }

            @Override
            public Object next() {
                if (!hasNext()){
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
