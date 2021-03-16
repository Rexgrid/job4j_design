package ru.job4j.Collections;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import java.util.List;

public class AnalizeTest {

    @Before
    public void setUp() {
        List<Analize.User> cur = List.of(new Analize.User(1, "asd"),
                new Analize.User(2, "asda"),
                new Analize.User(3, "asdw"));
    }

    @Test
    public void whenWeTest() {
        List<Analize.User> def = List.of(
                new Analize.User(1, "asd"),
                new Analize.User(2, "asda"),
                new Analize.User(3, "asdw"),
                new Analize.User(4, "asd"),
                new Analize.User(5, "asda"));

    }
}