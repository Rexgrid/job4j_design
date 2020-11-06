package ru.job4j.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimplyArrayTest {

    @Test
    public void whenAddThenGet() {
        SimplyArray<String> array = new SimplyArray<>();
        array.add("first");
        String rsl = array.get(0);
        assertThat(rsl, is("first"));
    }

    @Test
    public void whenAddMoreThenStartCapacity() {
        SimplyArray<Integer> array = new SimplyArray<>();
        array.add(1);
        array.add(2);
        array.add(1);
        array.add(2);
        array.add(1);
        array.add(2);
        array.add(1);
        array.add(2);
        array.add(1);
        array.add(2);
        array.add(1);
        array.add(2);
        Integer rsl = array.get(11);
        assertThat(rsl, is(2));
    }

    @Test
    public void whenAddThenIt() {
        SimplyArray<String> array = new SimplyArray<>();
        array.add("first");
        String rsl = array.iterator().next();
        assertThat(rsl, is("first"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetEmpty() {
        SimplyArray<String> array = new SimplyArray<>();
        array.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetOutBound() {
        SimplyArray<String> array = new SimplyArray<>();
        array.add("first");
        array.get(1);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimplyArray<String> array = new SimplyArray<>();
        array.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        SimplyArray<String> array = new SimplyArray<>();
        array.add("first");
        Iterator<String> it = array.iterator();
        array.add("second");
        it.next();
    }
}