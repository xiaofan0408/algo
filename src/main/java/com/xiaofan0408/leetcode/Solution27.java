package com.xiaofan0408.leetcode;

/**
 * @author xuzefan  2019/11/4 18:11
 */
public class Solution27 {

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int index = 0;
        for (int i=0;i < nums.length;i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

}
