package com.xiaofan0408.leetcode2;

public class Solution704 {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left)/2;
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target){
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{-1,0,3,5,9,12};
        Solution704 solution704 = new Solution704();
        int res =solution704.search(nums,9);
        System.out.println(res == 4);
    }

}
