package com.xiaofan0408.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xuzefan  2019/7/29 11:45
 */
public class Solution1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i =0;i < nums.length;i++) {
            int num = nums[i];
            if (map.get(num)==null){
                map.put(num,i);
            }
            int res = target - num;
            if(map.get(res)!=null && map.get(res)!= i){
                return new int[]{map.get(res),i};
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Solution1 twoSum = new Solution1();
        int[] nums = {0,4,3,0};
        int target = 0;
        int[] result = twoSum.twoSum(nums,target);
        System.out.println(Arrays.toString(result));

        int[] nums2 = {3,2,4};
        int target2 = 6;
        int[] result2 = twoSum.twoSum(nums2,target2);
        System.out.println(Arrays.toString(result2));
    }
}
