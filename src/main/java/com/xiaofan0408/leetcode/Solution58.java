package com.xiaofan0408.leetcode;

/**
 * @author xuzefan  2019/11/7 17:01
 */
public class Solution58 {

    public int lengthOfLastWord(String s) {
        if (s == null && s.length() == 0) {
            return 0;
        }
        String[] strings = s.split(" ");
        if (strings.length <=0) {
            return  0;
        } else {
            return strings[strings.length - 1].length();
        }
    }

}
