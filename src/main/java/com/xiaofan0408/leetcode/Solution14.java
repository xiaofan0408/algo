package com.xiaofan0408.leetcode;

/**
 * @author xuzefan  2019/8/8 11:37
 */
public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];

        for (int i = 1; i < strs.length; ++i) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty()) {
                    break;
                }
            }
        }

        return prefix;
    }
}
