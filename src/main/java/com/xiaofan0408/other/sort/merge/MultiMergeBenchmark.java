package com.xiaofan0408.other.sort.merge;


import com.xiaofan0408.other.sort.SortUtil;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
public class MultiMergeBenchmark {

    @Param({"5","10"})
    private Integer length;

    private MultiMergeSort mergeSort;

     private int numElements = 16 << 20;

     private int[] origin = new int[numElements];


    @Setup
    public void init(){
        mergeSort = new MultiMergeSort();
        SortUtil.prepare(origin);
    }

    @Benchmark
    public void testMerge(){
        int[] src = Arrays.copyOf(origin, origin.length);
        mergeSort.sort(src);
    }

    @Benchmark
    public void testSort(){
        int[] src = Arrays.copyOf(origin, origin.length);
        Arrays.sort(src);
    }

    @Benchmark
    public void testPSort(){
        int[] src = Arrays.copyOf(origin, origin.length);
        Arrays.parallelSort(src);
    }


    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                // 导入要测试的类
                .include(MultiMergeBenchmark.class.getSimpleName())
                // 预热5轮
                .warmupIterations(1)
                // 度量10轮
                .measurementIterations(2)
                .mode(Mode.AverageTime)
                .timeUnit(TimeUnit.NANOSECONDS)
                .forks(1)
                .output("./log/multi-merge-3.log")
                .build();

        new Runner(opt).run();

    }

}
