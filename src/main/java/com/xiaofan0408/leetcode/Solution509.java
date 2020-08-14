package com.xiaofan0408.leetcode;

/**
 * @author xuzefan  2020/8/14 11:38
 */
public class Solution509 {

    public int fib(int N) {
        if (N < 1){
            return 0;
        }
        if (N == 1 || N ==2) {
            return 1;
        }
        int curr = 1;
        int prev = 1;
        for (int i=3;i <= N;i++) {
            int sum = curr + prev;
            prev = curr;
            curr = sum;
        }
        return curr;
    }

    public int fib2(int N) {
        int[] array = new int[N + 1];
        array[1] = 1;
        array[2] = 1;
        for (int i=3;i <= N;i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[N];
    }

    public int fib3(int N) {
        if (N < 1) {
            return 0;
        }
        int[] array = new int[N + 1];
        return fib3CallBack(N,array);
    }

    public int fib3CallBack(int N, int[] array){
        if (N == 1 || N ==2) {
            return 1;
        }
        if (array[N] != 0) {
            return array[N];
        }
        array[N] = fib3CallBack(N - 1,array) +  fib3CallBack(N - 2,array);
        return array[N];
    }


    public int fib4(int N) {
        if (N == 1 || N ==2) {
            return 1;
        }
        return fib4(N-1) + fib4(N - 2);
    }

    public static void main(String[] args) {
        Solution509 solution509 = new Solution509();
        System.out.println(solution509.fib4(10));
        System.out.println(solution509.fib3(10));
        System.out.println(solution509.fib2(10));
        System.out.println(solution509.fib(10));
    }
}
