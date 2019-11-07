package com.xiaofan0408.leetcode;

/**
 * @author xuzefan  2019/11/7 17:10
 */
public class Solution67 {
    public String addBinary(String a, String b) {
        if(a == null || a.isEmpty()) {
            return b;
        }
        if(b == null || b.isEmpty()) {
            return a;
        }
        StringBuffer result = new StringBuffer();
        int i = 0;
        int len1 = a.length();
        int len2 = b.length();
        while (len1 > -1 || len2 > -1) {
            int aValue = len1 > -1 ? Character.getNumericValue(a.charAt(len1)) : 0;
            int bValue = len2 > -1 ? Character.getNumericValue(b.charAt(len2)) : 0;
        }
        return result.reverse().toString();
    }
}
