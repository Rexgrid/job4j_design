package ru.job4j.Collections;

import java.util.*;
import java.util.stream.Collectors;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        Info rsl = new Info(0, 0, 0);
        Map<User, User> cur = current.stream().collect(Collectors.toMap(k -> k, v -> v));
        for (User prev : previous) {
            if (cur.get(prev) == null) {
                rsl.deleted++;
            } else if (cur.get(prev).getId() == prev.getId() && !cur.get(prev).getName().equals(prev.getName())) {
                rsl.changed++;
            }
        }
        rsl.added = current.size() - previous.size() + rsl.deleted;
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

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Info info = (Info) o;
            return added == info.added &&
                    changed == info.changed &&
                    deleted == info.deleted;
        }

        @Override
        public int hashCode() {
            return Objects.hash(added, changed, deleted);
        }
    }


}
