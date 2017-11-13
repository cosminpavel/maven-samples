package com.lab2.repository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Cosmin on 10/17/2017.
 */
public class HashSetBasedRepository<T> implements InMemoryRepository<T> {
    private Set<T> set;

    public HashSetBasedRepository() {
        this.set = new HashSet<>();
    }

    @Override
    public void add(T t) {
        set.add(t);
    }

    @Override
    public boolean contains(T t) {
        return set.contains(t);
    }

    @Override
    public void remove(T t) {
        set.remove(t);
    }

    @Override
    public void clear() {
        set.clear();
    }
}
