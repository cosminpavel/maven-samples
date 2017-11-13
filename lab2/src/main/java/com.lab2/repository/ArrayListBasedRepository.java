package com.lab2.repository;

import java.util.ArrayList;

/**
 * Created by Cosmin on 10/17/2017.
 */
public class ArrayListBasedRepository<T> implements InMemoryRepository<T> {
    private ArrayList<T> list;

    public ArrayListBasedRepository() {
        this.list = new ArrayList<>();
    }

    @Override
    public void add(T t) {
        list.add(t);
    }

    @Override
    public boolean contains(T t) {
        return list.contains(t);
    }

    @Override
    public void remove(T t) {
        list.remove(t);

    }

    @Override
    public void clear() {
        list.clear();
    }
}
