package ru.job4j.Collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public T deleteFirst() {
        if (head == null || head.next == null) {
            throw new NoSuchElementException();
        }
        head = head.next;
        return head.value;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public T deleteLast() {
        Node<T> prev = head;
        Node<T> next = head;
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        while (next.next != null) {
            prev = next;
            next = next.next;
        }
        if (next == head) {
            head = null;
        }
        prev.next = null;
        return next.value;
    }

    public void revert() {
        Node<T> prev = null;
        Node<T> current = head;
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
       while (current != null) {
           Node<T> next = current.next;
          current.next = prev;
           prev = current;
           current = next;
       }
       head = prev;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}