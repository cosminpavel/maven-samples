package com.lab2.states;

import com.lab2.repository.InMemoryRepositoryPrimitive;
import org.openjdk.jmh.annotations.*;

import java.util.stream.IntStream;

/**
 * Created by Cosmin on 12/11/2017.
 */
@State(Scope.Benchmark)
public class PrimitiveRepoState {
    @Param
    private PrimitiveRepositorySupplier intRepositorySupplier;

    public InMemoryRepositoryPrimitive list;

    /* run before each benchmark */
    @Setup
    public void setUp(IntSizeState sizeState) {
        System.out.println(getClass().getSimpleName() + " > setup > populate");
        list = intRepositorySupplier.get();

        IntStream.rangeClosed(1, sizeState.size)
                .forEach(list::add);
    }

    /* run after each benchmark */
    @TearDown
    public void tearDown() {
        System.out.println(getClass().getSimpleName() + " > teardown > clear");
        list.clear();
        System.gc();
    }
}
