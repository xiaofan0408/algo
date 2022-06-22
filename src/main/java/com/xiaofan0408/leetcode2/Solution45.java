package com.xiaofan0408.leetcode2;

public class Solution45 {

    public int jump(int[] nums) {
        int max = 0;
        int ans = 0;
        int end = 0;
        for (int i = 0; i< nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == end) {
                end = max;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution45 solution45 = new Solution45();
        System.out.println(solution45.jump(new int[]{2,3,0,1,4}));
    }

}
