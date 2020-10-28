package ru.job4j.Collections;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


import org.hamcrest.core.IsNot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;
public class SimpleArrayTest {

    private SimpleArray<Integer> sA;
    private Integer[] listModel;

    @Before
    public void setUp() {
       sA = new SimpleArray<>(5);
    }

    @Test (expected = IndexOutOfBoundsException.class)
   public void whenOutOfBounds(){
     sA.add(3);
     sA.add(2);
     sA.add(3);
     sA.add(2);
     sA.add(3);
     sA.add(2);
     }

     @Test
     public void wheAddModel() {
        sA.add(1);
        sA.add(2);
        sA.add(3);
        sA.add(4);
        sA.add(5);
        assertThat(sA.get(1), is(2));
     }

    @Test
    public void whenSetModel() {
        sA = new SimpleArray<>(3);
        sA.add(1);
        sA.add(2);
        sA.add(3);
        sA.set(1, 3);
        assertThat(sA.get(1), is(3));
    }

    @Test (expected = IndexOutOfBoundsException.class )
    public void whenDeleteModel() {
        sA = new SimpleArray<>(3);
        sA.add(1);
        sA.add(2);
        sA.add(3);
        sA.remove(2);
        sA.get(2);
    }

    @Test
    public void whenWeGetModel() {
        sA.add(2);
        sA.add(1);
        assertThat(sA.get(0), is (2));
    }

    @Test
    public void whenIteratorHasNext() {
        sA.add(2);
        sA.add(1);
        assertThat(sA.iterator().hasNext(), is(true));
        assertThat(sA.iterator().hasNext(), is(true));
    }

    @Test
    public void whenIteratorHasntNext() {
        assertThat(sA.iterator().hasNext(), is(false));
    }
}
