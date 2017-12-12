package com.lab2.repository;

/**
 * Created by Cosmin on 10/30/2017.
 */
public interface InMemoryRepositoryPrimitive {
    void add(int e);

    boolean contains(int e);

    void remove(int e);

    void clear();
}
