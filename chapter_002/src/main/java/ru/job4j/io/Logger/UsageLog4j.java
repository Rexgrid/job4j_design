package ru.job4j.io.Logger;

import org.apache.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
      String name = "Alex";
      int age = 26;
      double weight = 86.5;
      float p  = 3.1415926535F;
      byte two = 0b10;
      char initials = 'A';
      boolean wannaLearn = true;
      long maxValue = 9223372036854775807L;
      LOG.debug("User info name : {}, age : {}", name, age);
      LOG.debug("My weight : {}, first character of my name : {}", weight, initials);
      LOG.debug("What is the number Pi : {}, the bytes 0b10 equal to : {}", p, two);
      LOG.debug("Do I want to learn java : {}, what is long max value? : {}", wannaLearn, maxValue);
    }
}