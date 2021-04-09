package ru.job4j.io;


import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import java.io.*;

public class AnalizyTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenWeHaveOneDrop() throws IOException{
        File source  = folder.newFile("source.txt");
        File target = folder.newFile("target.txt");
        try (PrintWriter out = new PrintWriter(source)){
            out.println(" 200 10:56:01");
            out.println(" 500 10:57:01");
            out.println(" 400 10:58:01");
            out.println(" 200 10:59:01");
        }
        Analizy an = new Analizy();
        an.unavailable(source.getAbsolutePath());
        an.writeInTarget(target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))){
            in.lines().forEach(rsl::append);
        }

        assertThat(rsl.toString(), is("10:57:01;10:59:01"));
    }
}
