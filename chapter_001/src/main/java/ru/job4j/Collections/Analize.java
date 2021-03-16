package ru.job4j.Collections;

import java.util.*;
import java.util.stream.Collectors;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        Info rsl = new Info();
        Map<Integer, String> prev = previous.stream().collect(Collectors.toMap(User::getId, User::getName));
        for (User us : current) {
            if (prev.containsKey(us.getId()) && !prev.get(us.getId()).equals(us.getName())) {
                current.remove(us);
                rsl.changed++;
            } else if (!prev.containsKey(us.getId())) {
                current.remove(us);
                rsl.added++;
            }
        }
        rsl.deleted = current.size();
        return rsl;

    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }


        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return id == user.id &&
                    Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    public static class Info {

        int added;
        int changed;
        int deleted;

    }

}
