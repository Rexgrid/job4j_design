package ru.job4j.Collections;

import static org.hamcrest.CoreMatchers.is;
        import static org.junit.Assert.assertEquals;
        import static org.junit.Assert.assertThat;


        import org.hamcrest.core.IsNot;
        import org.junit.Assert;
        import org.junit.Before;
        import org.junit.Test;

public class SimpleMapTest {
    private SimpleMap<Integer, Integer> sM;

    @Before
    public void setUp() {
        sM = new SimpleMap<>();
    }

    @Test
    public void whenInsertThenAddItem() {
        sM.insert(12, 22);
        sM.insert(11, 45);
        assertThat(sM.getCount(), is(2));
    }

}
