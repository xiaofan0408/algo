package com.xiaofan0408.leetcode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.IntConsumer;

/**
 * @author xuzefan  2019/11/8 13:32
 */
public class Solution1116 {
   static class ZeroEvenOdd {
        private int n;
        private volatile boolean printZero = true;
       private volatile boolean printOdd = true;

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i=0;i < n;i++) {
                synchronized (this){
                    while (!printZero){
                        wait();
                    }
                    printNumber.accept(0);
                    printZero = false;
                    notifyAll();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i=2;i <=n;i+=2) {
               synchronized (this){
                   while (printZero || printOdd){
                       wait();
                   }
                   printNumber.accept(i);
                   printZero = true;
                   printOdd = true;
                   notifyAll();
               }
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i=1;i <= n;i+=2) {
               synchronized (this){
                   while (printZero || !printOdd){
                       wait();
                   }
                   printNumber.accept(i);
                   printZero = true;
                   printOdd = false;
                   notifyAll();
               }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
       long startTime = System.currentTimeMillis();
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(3);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(() -> {
            try {
                zeroEvenOdd.zero( (x) -> System.out.print(x));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.submit(() -> {
            try {
                zeroEvenOdd.even( (x) -> System.out.print(x));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.submit(() -> {
            try {
                zeroEvenOdd.odd( (x) -> System.out.print(x));
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
