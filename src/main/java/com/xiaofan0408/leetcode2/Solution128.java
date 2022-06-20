package com.xiaofan0408.leetcode2;

import java.util.HashSet;
import java.util.Set;

public class Solution128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hash = new HashSet<Integer>();
        for(int x : nums) hash.add(x);
        int res = 0;
        for(int x : hash)
        {
            if(!hash.contains(x-1))
            {
                int y = x;
                while(hash.contains(y + 1)) y++;
                res = Math.max(res, y - x + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution128 solution128 = new Solution128();
        System.out.println(solution128.longestConsecutive(new int[]{100,4,200,1,3,2}));
    }

}
