package ru.job4j.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


import org.hamcrest.core.IsNot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

public class MapsTest {
    private Maps<Integer, String> dt;

    @Before
    public void setUp() {
        dt = new Maps<>();
    }

    @Test
    public void whenAddDataAndGetOne() {
        dt.insert(1, "asd");
        dt.insert(2, "as");
        assertThat(dt.get(1), is("asd"));
    }

    @Test
    public void whenUseResize() {
        dt.insert(88, "asd");
        dt.insert(352, "as");
        dt.insert(3444, "asd");
        dt.insert(5456466, "asd");
        dt.insert(367876842, "as");
        dt.insert(34485464, "asd");
        dt.insert(8444878, "asd");
        dt.insert(311125452, "as");
        dt.insert(348888844, "asd");
        dt.insert(3521111, "as");
        dt.insert(34442222, "asd");
        dt.insert(54563333, "asd");
        dt.insert(368764444, "as");
        dt.insert(348546455, "asd");
        dt.insert(848444878, "asd");
        dt.insert(377125452, "as");
        dt.insert(349988844, "asd");
        dt.insert(8111118, "asd");
        dt.insert(35345672, "as");
        dt.insert(344111234, "asd");
        dt.insert(54560466, "asd");
        dt.insert(367909, "as");
        dt.insert(3446412, "asd");
        dt.insert(8443468, "asd");
        dt.insert(311585452, "as");
        dt.insert(3467884, "asd");
        dt.insert(352231111, "as");
        dt.insert(344421222, "asd");
        dt.insert(545632333, "asd");
        dt.insert(3684, "as");
        dt.insert(46455, "asd");
        dt.insert(78, "asd");
        dt.insert(3772, "as");
        dt.insert(34124544, "asd");
        assertThat(dt.getCapacity(), is(32));
    }

    @Test
    public void whenDeleted() {
        dt.insert(1, "as");
        assertThat(dt.delete(1), is(true));
    }

    @Test
    public void whenHasNext() {
        dt.insert(1, "as");
        dt.insert(312, "aa");
        Iterator iter = dt.iterator();
        iter.next();
        assertThat(iter.hasNext(), is(true));
    }
}
