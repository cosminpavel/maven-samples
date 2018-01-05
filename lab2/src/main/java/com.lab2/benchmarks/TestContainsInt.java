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
public class TestContainsInt {

    @State(Scope.Benchmark)
    public static class BeforeState {
        public int number;

        @Setup(Level.Invocation)
        public void generateNumber(IntSizeState sizeState) {
            number = sizeState.before.get();
        }
    }

    @State(Scope.Benchmark)
    public static class ExistingState {
        public int number;

        @Setup(Level.Invocation)
        public void generateNumber(IntSizeState sizeState) {
            number = sizeState.existing.get();
        }
    }

    @State(Scope.Benchmark)
    public static class AfterState {
        public int number;

        @Setup(Level.Invocation)
        public void generateNumber(IntSizeState sizeState) {
            number = sizeState.after.get();
        }
    }

    @Benchmark
    public void containsBefore(PrimitiveRepoState repoState, BeforeState before, Blackhole blackhole) {
        repoState.list.contains(before.number);
        blackhole.consume(repoState);
    }

    @Benchmark
    public void containsExisting(PrimitiveRepoState repoState, ExistingState existing, Blackhole blackhole) {
        repoState.list.contains(existing.number);
        blackhole.consume(repoState);
    }

    @Benchmark
    public void containsAfter(PrimitiveRepoState repoState, AfterState after, Blackhole blackhole) {
        repoState.list.contains(after.number);
        blackhole.consume(repoState);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(TestContainsInt.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}