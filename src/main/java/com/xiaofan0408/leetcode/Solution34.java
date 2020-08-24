package com.xiaofan0408.leetcode;

/**
 * @author xuzefan  2020/8/24 15:32
 */
public class Solution34 {

    //Input: nums = [5,7,7,8,8,10], target = 8
    //Output: [3,4]
    //
    // Example 2:
    //
    //
    //Input: nums = [5,7,7,8,8,10], target = 6
    //Output: [-1,-1]

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        if (nums.length == 0) {
            return result;
        }
        result[0] = findFirst(nums,target);
        result[1] = findLast(nums,target);
        return result;
    }

    private int findFirst(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;

            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (left >= nums.length || nums[left] != target) {
           return -1;
        } else {
           return left;
        }
    }

    private int findLast(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (right < 0 || nums[right] != target) {
            return -1;
        } else {
            return right;
        }
    }

    public static void main(String[] args) {
        Solution34 solution34 = new Solution34();
        int[] r1= solution34.searchRange(new int[]{5,7,7,8,8,10},8);
        int[] r2 = solution34.searchRange(new int[]{2,2},3);
        System.out.printf("%d,%d\n",r1[0],r1[1]);
        System.out.printf("%d,%d\n",r2[0],r2[1]);
    }

}
