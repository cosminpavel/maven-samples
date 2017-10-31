package com.lab2.repository;

/**
 * Created by Cosmin on 10/30/2017.
 */
public interface InMemoryRepositoryPrimitive {
    void add(long e);

    boolean contains(long e);

    void remove(long e);

    void clear();
}
