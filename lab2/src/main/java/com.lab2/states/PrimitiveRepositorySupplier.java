package com.lab2.states;

import com.lab2.primitiveRepo.FastUtilHashSetRepo;
import com.lab2.primitiveRepo.KolobokeHashSetRepo;
import com.lab2.repository.InMemoryRepositoryPrimitive;

import java.util.function.Supplier;

/**
 * Created by Cosmin on 12/11/2017.
 */
public enum PrimitiveRepositorySupplier implements Supplier<InMemoryRepositoryPrimitive> {
    KOLOBOKE_HASH_SET() {
        @Override
        public InMemoryRepositoryPrimitive get() {
            return new KolobokeHashSetRepo();
        }
    },
    FASTUTIL_HASH_SET(){
        @Override
        public InMemoryRepositoryPrimitive get() {
            return new FastUtilHashSetRepo();
        }
    }
}
