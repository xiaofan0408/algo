package com.xiaofan0408.leetcode2;

public class Solution55 {

    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i=0; i< nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        Solution55 solution55 = new Solution55();
        System.out.println(solution55.canJump(new int[]{3,2,1,0,4}));
    }

}
