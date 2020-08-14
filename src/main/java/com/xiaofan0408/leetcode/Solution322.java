package com.xiaofan0408.leetcode;

import org.apache.commons.math3.analysis.function.Max;

import java.util.Arrays;

/**
 * @author xuzefan  2020/8/14 15:26
 */
public class Solution322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount + 1);
        dp[0] = 0;
        for (int i=1; i <= amount; i++) {
            for (int c: coins) {
                if (i - c < 0) {
                    continue;
                } else {
                    dp[i] = Math.min(dp[i],1 + dp[i-c]);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public int coinChange2(int[] coins, int amount) {
       if (amount < 0 ) {
           return -1;
       }
        if (amount == 0) {
            return 0;
        }
        int min = amount + 1;
        for (int c:coins) {
            if (amount - c < 0) {
                continue;
            }
            int last = coinChange2(coins,amount - c);
            if (last < 0){
                min = -1;
            }
            min = Math.min(min, 1 + last );
        }
        return min == amount +1 ? -1: min;
    }

    public static void main(String[] args) {
        Solution322 solution322 = new Solution322();
        System.out.println(solution322.coinChange(new int[]{1,2,5},100));
        System.out.println(solution322.coinChange(new int[]{2},4));

        System.out.println(solution322.coinChange2(new int[]{1,2,5},100));
        System.out.println(solution322.coinChange2(new int[]{2},4));
    }
}
