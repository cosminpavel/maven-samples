package com.lab2.benchmarks;

import com.lab2.Order;
import com.lab2.states.RepoState;
import com.lab2.states.SizeState;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * Created by Cosmin on 11/28/2017.
 */
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 4, time = 1)
@Measurement(iterations = 10, time = 1)
@Fork(2)
public class TestContains {

    @State(Scope.Benchmark)
    public static class BeforeState {
        public Order order;

        @Setup(Level.Invocation)
        public void generateOrder(SizeState sizeState) {
            order = sizeState.before.get();
        }
    }

    @State(Scope.Benchmark)
    public static class ExistingState {
        public Order order;

        @Setup(Level.Invocation)
        public void generateOrder(SizeState sizeState) {
            order = sizeState.existing.get();
        }
    }

    @State(Scope.Benchmark)
    public static class AfterState {
        public Order order;

        @Setup(Level.Invocation)
        public void generateOrder(SizeState sizeState) {
            order = sizeState.after.get();
        }
    }

    @Benchmark
    public void containsBefore(RepoState repoState, BeforeState before, Blackhole blackhole) {
        blackhole.consume(repoState.orders.contains(before.order));
    }

    @Benchmark
    public void containsExisting(RepoState repoState, ExistingState existing, Blackhole blackhole) {
        blackhole.consume(repoState.orders.contains(existing.order));
    }

    @Benchmark
    public void containsAfter(RepoState repoState, AfterState after, Blackhole blackhole) {
        blackhole.consume(repoState.orders.contains(after.order));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(TestContains.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}