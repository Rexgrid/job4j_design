package ru.job4j.It;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIterator implements Iterator<Integer> {
   private final int[] data;
   private int point = 0;

    public EvenIterator(int[] data) {
       this.data = data;
    }

        @Override
        public boolean hasNext () {
          while (data.length - 1 > point && data[point] % 2 != 0) {
              point++;
            }
            return data[point] % 2 == 0;
        }

        @Override
        public Integer next () {
           if (!hasNext()) {
               throw  new NoSuchElementException();
           }
           return data[point++];
        }

}
