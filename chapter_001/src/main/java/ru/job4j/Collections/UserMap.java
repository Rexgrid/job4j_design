package ru.job4j.Collections;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class UserMap {
    public static void main(String[] args) {
        User us1 = new User("Alex", 0, new GregorianCalendar(1993, 1, 25));
        User us2 = new User("Alex", 0, new GregorianCalendar(1993, 1, 25));
        Map<User,Object> usm = new HashMap<>();
        usm.put(us1,1);
        usm.put(us2,2);
        System.out.println(usm);
            }
}
