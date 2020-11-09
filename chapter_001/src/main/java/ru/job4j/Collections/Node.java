package ru.job4j.Collections;

public class Node<E> {
     E item;
     Node<E> next;


    Node(E element) {
        this.item = element;
    }

    public E getItem() {
        return item;
    }
}
