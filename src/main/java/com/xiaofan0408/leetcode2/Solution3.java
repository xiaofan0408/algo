package com.xiaofan0408.leetcode2;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int start = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i=0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            Integer index = map.get(ch);
            if (index != null) {
                if (start < index + 1) {
                    start = index + 1;
                }
            }
            map.put(ch,i);

            if (i - start + 1> max) {
                max = i - start + 1;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.lengthOfLongestSubstring("dvdf"));
    }

}
