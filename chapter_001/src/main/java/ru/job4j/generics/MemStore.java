package ru.job4j.generics;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Objects;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        if (indexOf(id) >= 0) {
            mem.set(indexOf(id), model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        if (indexOf(id) >= 0) {
            mem.remove(indexOf(id));
            return true;
        }
        return false;
    }

    @Override
    public T findById(String id) {
        T result = null;
        for (T t : mem) {
            if (t.getId().equals(id)) {
                result = t;
            }
        }
        return result;
    }

    public int indexOf(String id) {
        int result = 0;
        for (int i = 0; i < mem.size(); i++) {
            if (mem.get(i).getId().equals(id)) {
                result = i;
            } else {
                result = -1;
            }
        }
        return result;
    }
}