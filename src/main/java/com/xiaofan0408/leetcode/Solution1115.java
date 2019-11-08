package com.xiaofan0408.leetcode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author xuzefan  2019/11/8 11:34
 */
public class Solution1115 {

    static class FooBar {
        private int n;
        private volatile boolean fooPrint = true;

        public FooBar(int n) {
            this.n = n;
        }
        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                synchronized (this) {
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    while (!fooPrint) {
                        wait();
                    }
                    printFoo.run();
                    fooPrint = false;
                    notifyAll();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                synchronized (this) {
                    while (fooPrint){
                        wait();
                    }
                    // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();
                    fooPrint = true;
                    notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(3);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            try {
                fooBar.foo(() -> System.out.print("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.submit(() -> {
            try {
                fooBar.bar(() -> System.out.print("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

}
