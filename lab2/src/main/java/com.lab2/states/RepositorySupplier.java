package com.lab2.states;

import com.lab2.Order;
import com.lab2.repository.*;
import org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor;

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
    }

}