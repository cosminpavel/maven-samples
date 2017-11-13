package com.lab2.benchmarks;

import com.lab2.Order;
import com.lab2.states.RepoState;
import com.lab2.states.SizeState;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by Cosmin on 10/30/2017.
 */
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 2, time = 1)
@Measurement(iterations = 5, time = 1)
@Fork(2)
public class TestRemove {
    @State(Scope.Benchmark)
    public static class BeforeState {
        private Order order;

        @Setup(Level.Invocation)
        public void removeOrder(RepoState repoState) {
            repoState.orders.remove(order);
        }
        @TearDown(Level.Invocation)
        public void generateOrder(SizeState sizeState) {
            order = sizeState.before.get();
        }


    }
}
