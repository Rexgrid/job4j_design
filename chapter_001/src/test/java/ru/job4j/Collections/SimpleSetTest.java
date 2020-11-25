package ru.job4j.Collections;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class SimpleSetTest {

    @Test (expected = NoSuchElementException.class)
    public void whenAddNewElement() {
        SimpleSet<Integer> input = new SimpleSet<>();
        input.add(1);
        input.add(2);
        input.add(1);
        Iterator<Integer> it = input.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(1));
    }

}


