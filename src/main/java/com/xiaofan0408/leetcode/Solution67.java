package com.xiaofan0408.leetcode;

/**
 * @author xuzefan  2019/11/7 17:10
 */
public class Solution67 {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int al = a.length()-1;
        int bl = b.length()-1;
        int carry = 0;
        while( al >=0  || bl >=0 )
        {
            int sum = carry;
            if(al >= 0)
            {
                sum += (a.charAt(al) - '0');
                al--;
            }
            if(bl >= 0)
            {
                sum += (b.charAt(bl) - '0');
                bl--;
            }
            result.append(sum%2);
            carry = sum /2;
        }

        if(carry !=0 ) {
            result.append(1);
        }

        return result.reverse().toString();

    }
}
