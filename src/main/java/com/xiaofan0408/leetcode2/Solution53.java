package com.xiaofan0408.leetcode2;

public class Solution53 {

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int imax = 0;
        for (int i=0; i < nums.length; i++) {
            imax = Math.max(nums[i], imax + nums[i]);
            max = Math.max(imax, max);
        }

        return max;
    }

    public static void main(String[] args) {
        Solution53 solution53 = new Solution53();
        System.out.println(solution53.maxSubArray(new int[]{-1}));
    }

}
