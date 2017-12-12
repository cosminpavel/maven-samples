package com.lab2.repository;

import gnu.trove.set.hash.THashSet;

import java.util.Set;

/**
 * Created by Cosmin on 12/10/2017.
 */
public class Trove4jHashSetBasedRepository<T> implements InMemoryRepository<T> {
    private Set<T> set;
    public Trove4jHashSetBasedRepository(){
        set = new THashSet<>();
    }

    @Override
    public void add(T entity) {
        set.add(entity);
    }

    @Override
    public boolean contains(T entity) {
        return set.contains(entity);
    }

    @Override
    public void remove(T entity) {
        set.remove(entity);
    }

    @Override
    public void clear() {
        set.clear();
    }
}
