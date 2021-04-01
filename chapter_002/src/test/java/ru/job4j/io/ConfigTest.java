package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Petr Arsentev"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenWeHaveOnlyName() {
        String path = "./only_name.properties";
        Config config = new Config(path);
        config.load();
        System.out.println(config.value("name"));
    }


    @Test
    public void whenWeHaveOnlyComments() {
        String path = "./only_comments.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.getSize(), is(0));
    }
}
