package com.xiaofan0408.leetcode;

/**
 * @author xuzefan  2019/8/8 11:00
 */
public class Reverse {
    public int reverse(int x) {
        if ( x == 0){
            return 0;
        }
        int flag = x > 0 ? 1 : -1;
        x = x * flag;
        long result = 0;
        while (x >= 10){
            result = result + x%10;
            x = x / 10;
            result = result * 10;
        }
        result = result + x;
        long res = result * flag;
        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
            return 0;
        } else {
            return (int)res;
        }
    }

    public static void main(String[] args) {
        Reverse reverse = new Reverse();
        System.out.println(reverse.reverse(1534236469));
    }
}
