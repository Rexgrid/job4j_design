package ru.job4j.Collections;

import java.util.Calendar;
import java.util.Objects;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.birthday = birthday;
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return children == user.children &&
                name.equals(user.name) &&
                birthday.equals(user.birthday);
    }

    @Override
    public int hashCode() {
       int result = Integer.hashCode(children);
       result = 31 * result + name.hashCode();
       result = 31 * result + birthday.hashCode();
       return result;
    }
}
