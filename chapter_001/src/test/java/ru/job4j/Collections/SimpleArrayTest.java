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
        listModel = new Integer[] {1,2,3,4,5,6,7,8,null};
        sA = new SimpleArray<>(listModel);
    }

    @Test
   public void whenAddModel(){
     sA.add(3);
     Integer[] expected = {1,2,3,4,5,6,7,8,3};
     assertThat(listModel, is(expected));
     }

    @Test
    public void whenSetModel() {
    sA.set(1, 3);
    Integer[] expected = {1,3,3,4,5,6,7,8,null};
        assertThat(listModel, is(expected));
    }

    @Test
    public void whenDeleteModel() {
        sA.remove(3);
        Integer[] expected = {1,2,3,5,6,7,8, null, null};
        assertThat(listModel, is (expected));
    }

    @Test
    public void whenWeGetModel() {
        assertThat(sA.get(1), is (2));
    }

    @Test
    public void whenIteratorHasNext() {
        Iterator<Integer> it = new SimpleArrayIterator<>(listModel);
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
    }

    @Test
    public void whenIteratorHasntNext() {
        Integer [] listModel = {};
        Iterator<Integer> it = new SimpleArrayIterator<>(listModel);
        assertThat(it.hasNext(), is(false));
    }
}
