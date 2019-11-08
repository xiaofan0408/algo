package com.xiaofan0408.leetcode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.IntConsumer;

/**
 * @author xuzefan  2019/11/8 14:57
 */
public class Solution1195 {

   static class FizzBuzz {
        private int n;
        private Semaphore fizz;
        private Semaphore buzz;
        private Semaphore fizzBuzz;
        private Semaphore number;

        public FizzBuzz(int n) {
            this.n = n;
            fizz = new Semaphore(0,true);
            buzz = new Semaphore(0,true);
            fizzBuzz = new Semaphore(0,true);
            number = new Semaphore(1,true);
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            for (int i = 1;i <= n;i++){
                if (i % 3 == 0 && i % 5 != 0) {
                    fizz.acquire();
                    printFizz.run();
                    release(i + 1);
                }
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            for (int i = 1;i <= n;i++){
                if (i % 5 == 0 && i % 3 != 0) {
                    buzz.acquire();
                    printBuzz.run();
                    release(i + 1);
                }
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            for (int i = 1;i <= n; i++){
                if (i % 3 == 0 && i % 5 == 0) {
                    fizzBuzz.acquire();
                    printFizzBuzz.run();
                    release(i + 1);
                }
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1;i <= n;i++){
                if (i % 5 != 0 && i % 3  != 0) {
                    number.acquire();
                    printNumber.accept(i);
                    release(i + 1);
                }
            }
        }
        private void release(int v){
            if (v % 3 == 0 && v % 5 != 0) {
                fizz.release();
            } else if (v % 5 == 0 && v % 3 != 0) {
                buzz.release();
            } else if (v % 3 == 0 && v % 5 == 0) {
                fizzBuzz.release();
            } else if(v % 3 != 0 && v % 5 != 0){
                number.release();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        FizzBuzz fizzBuzz = new FizzBuzz(15);
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(() -> {
            try {
                fizzBuzz.fizz( () -> System.out.print("fizz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.submit(() -> {
            try {
                fizzBuzz.buzz(() -> System.out.print("buzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.submit(() -> {
            try {
                fizzBuzz.fizzbuzz(() -> System.out.print("fizzbuzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.submit(() -> {
            try {
                fizzBuzz.number( (x) -> System.out.print(x));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        System.out.println();
        System.out.println(System.currentTimeMillis() - startTime);
    }

}
