package com.xiaofan0408.leetcode2;

public class Solution121 {

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i=0 ; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                max = Math.max(prices[i] - min,max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution121 solution121 = new Solution121();
        System.out.println(solution121.maxProfit(new int[]{7,6,4,3,1}));
    }

}
