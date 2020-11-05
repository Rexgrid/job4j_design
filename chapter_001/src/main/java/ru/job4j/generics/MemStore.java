package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        if (id != null) {
            mem.set(indexOf(id), model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        if (id != null) {
            mem.remove(indexOf(id));
            return true;
        }
        return false;
    }

    @Override
    public T findById(String id) {
        return mem.get(indexOf(id));
    }

    public int indexOf(String id) {
        int result = -1;
        for (int i = 0; i < mem.size(); i++) {
            if (mem.get(i).getId().equals(id)) {
                result = i;
                break;
            }
        }
        return result;
    }
}