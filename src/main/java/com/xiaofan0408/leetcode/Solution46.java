package com.xiaofan0408.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xuzefan  2020/8/14 16:24
 */

//for 选择 in 选择列表:
//        # 做选择
//        将该选择从选择列表移除
//        路径.add(选择)
//        backtrack(路径, 选择列表)
//        # 撤销选择
//        路径.remove(选择)
//        将该选择再加入选择列表
public class Solution46 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums,track);
        return result;
    }


    private void backtrack(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            result.add(new ArrayList<>(track));
            return;
        }
        for (int n: nums) {
            if (track.contains(n)) {
                continue;
            }
            track.add(n);
            backtrack(nums,track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution46 solution46 = new Solution46();
        System.out.println(solution46.permute(new int[]{1,2,3}));
    }
}
