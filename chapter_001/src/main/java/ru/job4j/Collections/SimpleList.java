package ru.job4j.Collections;

import java.util.*;

public class SimpleList<E extends Node> implements Iterable<E> {

    private int size = 0;
    private int modCount = 0;
    transient Node<E> first;
    transient Node<E> last;


    public void add(E value) {
        Node<E> lst = last;
        Node<E> newNode = new Node<>(value);
        last = newNode;
        if (lst == null) {
            first = newNode;
        } else {
            lst.next = newNode;
        }
        size++;
        modCount++;
    }

    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> nd = first;
        for (int i = 0; i < index; i++) {
                nd = nd.next;
        }
        return nd.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private Node<E> current = first;
            private int nextIndex;
            private final int expectedModCount = modCount;


            @Override
            public boolean hasNext() {
                return nextIndex < size;
            }

            @Override
            public E next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<E> lastReturned = current;
                current = current.next;
                nextIndex++;
                return lastReturned.getItem();
            }
        };
    }
}