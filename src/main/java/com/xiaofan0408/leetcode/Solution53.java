package com.xiaofan0408.leetcode;

/**
 * @author xuzefan  2019/11/7 16:25
 */
public class Solution53 {

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i =0; i< nums.length; i++) {
            if (sum <= 0) {
                sum = nums[i];
            } else {
                sum = sum + nums[i];
            }
            if (max < sum) {
                max = sum;
            }
        }
        return max;
    }


    public int maxSubArrayDp(int[] nums) {
        int max =  nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i=1;i < nums.length;i++) {
            dp[i] = Math.max(dp[i -1] + nums[i],nums[i]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution53 solution53 = new Solution53();
        System.out.println(solution53.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(solution53.maxSubArrayDp(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

}
