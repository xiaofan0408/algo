package com.xiaofan0408.leetcode;

/**
 * @author xuzefan  2019/11/5 17:59
 */
public class Solution35 {
    public int searchInsert(int[] nums, int target) {
        if (nums[0] > target) {
            return 0;
        }
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }
        int lo = 0;
        int hi = nums.length - 1;
        int mid = (lo + hi) / 2;
        while (nums[mid] != target && hi > lo) {
            if (nums[mid] > target) {
                hi = mid - 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            }
            mid = (lo + hi) / 2;
        }
        if (nums[mid] >= target) {
            return mid;
        } else if (nums[mid] < target){
            return mid + 1;
        }
        return mid;
    }

    public static void main(String[] args) {
        Solution35 solution35 = new Solution35();
        int[] nums = new int[]{1,3,5,7,8};
        System.out.println(solution35.searchInsert(nums,1));
        System.out.println(solution35.searchInsert(nums,6));
        System.out.println(solution35.searchInsert(nums,2));
        System.out.println(solution35.searchInsert(nums,4));
        System.out.println(solution35.searchInsert(nums,0));
        System.out.println(solution35.searchInsert(nums,7));

    }
}
