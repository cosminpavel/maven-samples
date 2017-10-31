package com.lab2.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Cosmin on 10/30/2017.
 */
public class ConcurrentHashMapBaseRepository<T> implements InMemoryRepository<T>{
    Map<T,Boolean> map;

    public ConcurrentHashMapBaseRepository() {
        this.map = new ConcurrentHashMap<>();
    }

    @Override
    public void add(T o) {
        map.put(o,true);
    }

    @Override
    public boolean contains(T o) {
        return map.containsKey(o);
    }

    @Override
    public void remove(T o) {
        map.remove(o);
    }

    @Override
    public void clear() {
        map.clear();
    }
}
