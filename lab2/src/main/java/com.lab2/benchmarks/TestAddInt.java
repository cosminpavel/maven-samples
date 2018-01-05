package com.lab2.benchmarks;

import com.lab2.states.IntSizeState;
import com.lab2.states.PrimitiveRepoState;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * Created by Cosmin on 12/11/2017.
 */
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 2, time = 1)
@Measurement(iterations = 5, time = 1)
@Fork(2)
public class TestAddInt {
    @State(Scope.Benchmark)
    public static class BeforeState {
        public int element;

        @Setup(Level.Invocation)
        public void generateNumber(IntSizeState sizeState) {
            element = sizeState.before.get();
        }

        @TearDown(Level.Invocation)
        public void removeNumber(PrimitiveRepoState repoState) {
            repoState.list.remove(element);
        }
    }

    @State(Scope.Benchmark)
    public static class ExistingState {
        public int element;

        @Setup(Level.Invocation)
        public void generateNumber(IntSizeState sizeState) {
            element = sizeState.existing.get();
        }

        @TearDown(Level.Invocation)
        public void removeNumber(PrimitiveRepoState repoState) {
            repoState.list.remove(element);
        }
    }

    @State(Scope.Benchmark)
    public static class AfterState {
        public int element;

        @Setup(Level.Invocation)
        public void generateNumber(IntSizeState sizeState) {
            element = sizeState.after.get();
        }

        @TearDown(Level.Invocation)
        public void removeNumber(PrimitiveRepoState repoState) {
            repoState.list.remove(element);
        }
    }

    @Benchmark
    public void addBefore(PrimitiveRepoState repoState, BeforeState before, Blackhole blackhole) {
        repoState.list.add(before.element);
        blackhole.consume(repoState);
    }

    @Benchmark
    public void addExisting(PrimitiveRepoState repoState, ExistingState existing,  Blackhole blackhole) {
        repoState.list.add(existing.element);
        blackhole.consume(repoState);

    }

    @Benchmark
    public void addAfter(PrimitiveRepoState repoState, AfterState after, Blackhole blackhole) {
        repoState.list.add(after.element);
        blackhole.consume(repoState);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(TestAddInt.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}