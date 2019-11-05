package com.xiaofan0408.leetcode;

/**
 * @author xuzefan  2019/11/5 16:49
 */
public class Solution28 {

    public int strStr(String haystack, String needle) {
//        return haystack.indexOf(needle);
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        int index = -1;
        int i = 0;
        int count = 0;
        while (i< haystack.length()) {
            count = 0;
            if (needle.charAt(0) == haystack.charAt(i)) {
                for (int j = 0; j < needle.length() && j + i< haystack.length(); j++) {
                    if (needle.charAt(j) != haystack.charAt(i + j)) {
                        break;
                    } else {
                        count++;
                    }
                }
            }
            if (count == needle.length()) {
                index = i;
                return index;
            }
            i++;
        }
        return index;
    }

    public static void main(String[] args) {
        Solution28 solution28 = new Solution28();
        System.out.println(solution28.strStr("hello","ll"));
        System.out.println(solution28.strStr("aaaaa","bba"));
        System.out.println(solution28.strStr("",""));
        System.out.println(solution28.strStr("mississippi","issipi"));

    }

}
