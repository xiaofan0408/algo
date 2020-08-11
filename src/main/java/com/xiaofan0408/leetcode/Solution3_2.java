package com.xiaofan0408.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuzefan  2019/8/8 9:59
 */
public class Solution3_2 {

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Map<Character,Integer> map = new HashMap<>();
        int length = 0;
        int start = 0;
        for (int i=0;i < s.length();i++) {
            char ch = s.charAt(i);
            if (map.get(ch) == null) {
                map.put(ch,i);
                length++;
            } else {
                if (length > maxLength) {
                    maxLength = length;
                }
                start = Math.max(map.get(ch),start);
                length= i - start;
                map.put(ch,i);
            }
            if (length > maxLength) {
                maxLength = length;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Solution3_2 lengthOfLongestSubstring = new Solution3_2();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("abcabcdbb"));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("bbbbb"));
    }
}
