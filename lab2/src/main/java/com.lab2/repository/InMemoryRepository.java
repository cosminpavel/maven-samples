package com.lab2.repository;

/**
 * Created by Cosmin on 10/17/2017.
 */
public interface InMemoryRepository<T> {
    void add(T t);
    boolean contains(T t);
    void remove(T t);
    void clear();
}
