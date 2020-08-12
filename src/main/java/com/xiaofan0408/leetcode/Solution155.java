package com.xiaofan0408.leetcode;


import java.util.Arrays;

/**
 * @author xuzefan  2020/8/12 17:57
 */
public class Solution155 {
    static class MinStack {

        private int[] data;
        private int size;
        private int min;
        private Boolean change;

        /** initialize your data structure here. */
        public MinStack() {
            data = new int[100];
            size = -1;
            min = Integer.MAX_VALUE;
            change = false;
        }

        public void push(int x) {
            size++;
            data[size] = x;
            if ( x < min) {
                min = x;
            }
            if ((size + 1) >= data.length) {
                int[] temp = Arrays.copyOf(data,data.length * 2);
                data = temp;
            }
        }

        public void pop() {
            size--;
            change = true;
        }

        public int top() {
            return  data[size];
        }

        public int getMin() {
            if (change) {
                min = Integer.MAX_VALUE;
                for (int i=0;i<=size;i++) {
                    if ( data[i] < min) {
                        min = data[i];
                    }
                }
                change = false;
            }
            return min;
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}
