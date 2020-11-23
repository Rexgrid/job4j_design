package ru.job4j.It;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Predicate;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfter() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1,2,3));
        ListUtils.addAfter(input,0, 4);
        assertThat(Arrays.asList(1, 4, 2, 3), Is.is(input));
    }

    @Test
    public void whenPredicateTrueThenRemove() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 4, 6, 8));
        ListUtils.removeIf(input, x -> x % 2 != 0);
        assertThat(Arrays.asList(4, 6, 8), Is.is(input));
    }

    @Test
    public void whenPredicateTrueThenReplace() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 4, 6, 8));
        ListUtils.replaceIf(input, x -> x % 2 != 0, 2);
        assertThat(Arrays.asList(2, 4, 6, 8), Is.is(input));
    }

    @Test
    public void whenWeRemoveSameElements() {
        List<Integer> inputList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> inputElements = new ArrayList<>(Arrays.asList(1, 3, 5));
        ListUtils.removeAll(inputList, inputElements);
        assertThat(Arrays.asList(2, 4), Is.is(inputList));
    }
}