package com.xiaofan0408.leetcode;

/**
 * @author xuzefan  2019/11/4 17:34
 */
public class Solution26 {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int index = 0;
        for (int i=0;i < nums.length;i++) {
            if (nums[i] != nums[index]) {
                index++;
                nums[index] = nums[i];
            }
        }
        return index + 1;
    }

}
