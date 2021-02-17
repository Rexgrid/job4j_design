package ru.job4j.Collections;

import java.util.Objects;

public class Data<K, V> {

    private final K key;
    private final V value;
    private Data<K, V> prev;
    private Data<K, V> next;
    private Data<K, V> element;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data<?, ?> data = (Data<?, ?>) o;
        return Objects.equals(key, data.key) &&
                Objects.equals(value, data.value) &&
                Objects.equals(prev, data.prev) &&
                Objects.equals(next, data.next) &&
                Objects.equals(element, data.element);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value, prev, next, element);
    }

    public Data(int hash, K key, V value) {
        this.key = key;
        this.value = value;
    }



    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }


}
