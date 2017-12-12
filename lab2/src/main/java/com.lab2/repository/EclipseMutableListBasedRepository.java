package com.lab2.repository;

import org.eclipse.collections.impl.factory.Lists;

import java.util.List;

/**
 * Created by Cosmin on 12/10/2017.
 */
public class EclipseMutableListBasedRepository<T> implements InMemoryRepository<T> {

    private List<T> entities;

    public EclipseMutableListBasedRepository(){
        entities = Lists.mutable.empty();
    }

    @Override
    public void add(T entity) {
        entities.add(entity);
    }

    @Override
    public boolean contains(T entity) {
        return entities.contains(entity);
    }

    @Override
    public void remove(T entity) {
        entities.remove(entity);
    }

    @Override
    public void clear() {
        entities.clear();
    }
}