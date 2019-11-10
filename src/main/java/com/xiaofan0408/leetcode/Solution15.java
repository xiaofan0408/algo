package com.xiaofan0408.leetcode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author xuzefan  2019/11/8 17:29
 */
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null||nums.length<3){
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int num = nums[i];
            List<List<Integer>> res = twoSum(nums, i + 1,0 - num);
            if (res.size() > 0) {
                for (List<Integer> r: res) {
                    r.add(num);
                    result.add(r);
                }
            }
        }
        return result;
    }

    private List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i =start;i < nums.length;i++) {
            int num = nums[i];
            if (map.get(num)==null){
                map.put(num,i);
            }
            int res = target - num;
            if(map.get(res)!=null && map.get(res)!= i){
                List<Integer> tmp = new ArrayList<>();
                tmp.add(num);
                tmp.add(res);
                result.add(tmp);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        System.out.println(solution15.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(solution15.threeSum(new int[]{0,0,0,0}));
    }
}
