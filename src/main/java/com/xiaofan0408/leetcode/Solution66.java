package com.xiaofan0408.leetcode;

import java.util.Arrays;

/**
 * @author xuzefan  2019/9/30 16:40
 */
public class Solution66 {
    public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length + 1];
        int len = digits.length - 1;
        digits[len] = digits[len] + 1;
        for (int i = len; i>= 0;i--) {
            result[i + 1] = result[i + 1] + digits[i];
            if (result[i + 1] >= 10) {
                result[i + 1] = result[i+1] - 10;
                result[i] = 1;
            }
        }
        if (result[0] == 0) {
           return Arrays.copyOfRange(result,1,result.length);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution66 plusOne = new Solution66();
        int[] arr = new int[]{8,9,9};
        int[] res =plusOne.plusOne(arr);
        Arrays.stream(res).forEach( i -> {
            System.out.println(i);
        });
    }
}
