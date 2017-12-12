package com.lab2.states;

import com.lab2.Order;
import com.lab2.repository.*;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.function.Supplier;

/**
 * Created by Cosmin on 10/30/2017.
 */
public enum RepositorySupplier implements Supplier<InMemoryRepository<Order>> {
    HASH_SET() {
        @Override
        public InMemoryRepository<Order> get() {
            return new HashSetBasedRepository<>();
        }
    },


    TREE_SET() {
        @Override
        public InMemoryRepository<Order> get() {
            return new TreeSetBasedRepository<>();
        }
    },

    ARRAY_LIST() {
        @Override
        public InMemoryRepository<Order> get() {
            return new ArrayListBasedRepository<>();
        }
    },

    CONCURRENT_HASH_MAP() {
        @Override
        public InMemoryRepository<Order> get() {
            return new ConcurrentHashMapBaseRepository<>();
        }
    },
    ECLIPSE_MUTABLE_LIST(){
        @Override
        public InMemoryRepository<Order> get() {
            return new EclipseMutableListBasedRepository<>();
        }
    },
    TROVE4J_HASHSET() {
        @Override
        public InMemoryRepository<Order> get() {
            return new Trove4jHashSetBasedRepository<>();
        }
    }

}