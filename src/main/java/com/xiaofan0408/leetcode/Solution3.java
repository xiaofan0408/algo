package com.xiaofan0408.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuzefan  2019/8/8 9:59
 */
public class Solution3 {

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int start = 0;
        Map<Character,Integer> nums = new HashMap<>();
        for (int i=0;i < s.length();i++) {
            Character ch = s.charAt(i);
            Integer index = nums.get(ch);
            if (index!=null) {
               if (start < index + 1) {
                   start = index + 1;
               }
            }
            nums.put(ch,i);

            if (i - start + 1> maxLength) {
                maxLength = i - start + 1;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Solution3 lengthOfLongestSubstring = new Solution3();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("pwwkew"));
    }
}
