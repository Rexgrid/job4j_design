package ru.job4j.Collections;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class AnalizeTest {


    @Test
    public void whenWeAdded() {
        List<Analize.User> cur = new ArrayList<>();
        cur.add(new Analize.User(1, "asd"));
        cur.add(new Analize.User(2, "asda"));
        cur.add(new Analize.User(3, "asdw"));
        List<Analize.User> def = new ArrayList<>();
        def.add(new Analize.User(1, "asd"));
        def.add(new Analize.User(2, "asda"));
        def.add(new Analize.User(3, "asdw"));
        def.add(new Analize.User(4, "asd"));
        def.add(new Analize.User(5, "asdq"));
        Analize analize = new Analize();
        Analize.Info out = analize.diff(cur, def);
        Analize.Info expected = new Analize.Info(2,0,0);
        assertThat(out, is(expected));
    }

    @Test
    public void whenWeAdd2UsersAndDeleted1() {
        List<Analize.User> cur = new ArrayList<>();
        cur.add(new Analize.User(1, "asd"));
        cur.add(new Analize.User(2, "asda"));
        cur.add(new Analize.User(3, "asdw"));
        List<Analize.User> def = new ArrayList<>();
        def.add(new Analize.User(1, "asd"));
        def.add(new Analize.User(3, "asdw"));
        def.add(new Analize.User(4, "asd"));
        def.add(new Analize.User(5, "asdq"));
        Analize analize = new Analize();
        Analize.Info out = analize.diff(cur, def);
        Analize.Info expected = new Analize.Info(2,0,1);
        assertThat(out, is(expected));
    }
}