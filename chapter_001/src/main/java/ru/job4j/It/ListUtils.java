package ru.job4j.It;

import java.util.*;
import java.util.function.Predicate;

public class ListUtils {

    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (i.nextIndex() == index) {
                i.add(value);
                break;
            }
            i.next();
        }
    }

    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> iterator = list.listIterator();
        while (iterator.hasNext()) {
            if (iterator.previousIndex() == index) {
                iterator.add(value);
                break;
            }
            iterator.next();
        }


    }

    public static <T> List<T> removeIf(List<T> list, Predicate<T> filter) {
        ListIterator<T> li = list.listIterator();
        while (li.hasNext()) {
            if (filter.test(li.next())) {
                li.remove();
            }
        }
        return list;
    }

    public static <T> List<T> replaceIf(List<T> list, Predicate<T> filter, T value) {
        ListIterator<T> li = list.listIterator();
        while (li.hasNext()) {
            if(filter.test(li.next())) {
                li.set(value);
            }
        }
        return list;
    }

    public static <T> List<T> removeAll(List<T> list, List<T> elements) {
        ListIterator<T> itList = list.listIterator();
        while (itList.hasNext()) {
            if (elements.contains(itList.next())) {
                itList.remove();
            }
        }
        return list;
    }

}