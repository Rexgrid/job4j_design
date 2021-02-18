package ru.job4j.Collections;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleMap<K,V> implements Iterable {
   private Object[] hashArray;
    private K key;
    private V value;
    private int count = 0;
    private int size = 10;
    private int currentMod = 0;

    public SimpleMap() {
        this.hashArray = new Object[size];

    }

    public int hKey(K key) {
        return key.hashCode();
    }


    public boolean insert(K key, V value){
        if (hashArray[hKey(key)] == null) {
            hashArray[hKey(key)] = value;
            count++;
            currentMod++;
           return true;
        }
        return false;
    }

    public V get(K key) {
        if(isPresent(key)){
            return (V) hashArray[hKey(key)];
        }
        return null;
    }

    public boolean delete(K key){
        if (isPresent(key)){
            hashArray[hKey(key)] = -1;
            return true;
        }
        return false;
    }

    public boolean isPresent(K key){
        return hashArray[hKey(key)] != null;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {

            int cursor = 0;
           private final int currentModCount = currentMod;

            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
            public K next() {
                if (currentModCount != currentMod){
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()){
                    throw new NoSuchElementException();
                }
                return (K) hashArray[cursor++];
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleMap<?, ?> simpleMap = (SimpleMap<?, ?>) o;
        return key.equals(simpleMap.key) &&
                value.equals(simpleMap.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
