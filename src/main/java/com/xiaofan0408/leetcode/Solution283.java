package com.xiaofan0408.leetcode;

/**
 * @author xuzefan  2020/5/27 16:44
 */
public class Solution283 {

    public void moveZeroes(int[] nums) {
        int len=0;
        for (int i=0;i<nums.length;i++) {
            if (nums[i] != 0) {
                nums[len] = nums[i];
                len++;
            }
        }
        while (len < nums.length){
            nums[len] = 0;
            len++;
        }
    }

    public static void main(String[] args) {
        Solution283 solution283 = new Solution283();
        int[] nums = new int[]{0,1,0,3,12};
        solution283.moveZeroes(nums);
        for (int n:nums) {
            System.out.print(n+",");
        }
    }
}
