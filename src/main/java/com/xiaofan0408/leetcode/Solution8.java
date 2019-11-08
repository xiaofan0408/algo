package com.xiaofan0408.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuzefan  2019/8/8 14:36
 */
public class Solution8 {
    public int myAtoi(String str) {
        List<Character> characters = new ArrayList<>();
       for (int i = 0;i < str.length();i++) {
           char c = str.charAt(i);
           if (Character.isWhitespace(c)) {
               if (characters.size() > 0) {
                   break;
               } else {
                   continue;
               }
           }else if (Character.isDigit(c)) {
               characters.add(c);
           }else if (c == '-' || c == '+'){
               if (characters.size() <= 0) {
                   characters.add(c);
               } else {
                   break;
               }
           }else {
               break;
           }
       }

       if (characters.size() == 0) {
           return 0;
       } else{
           if (characters.size() >2) {
               if (characters.get(1)=='+' ||characters.get(1)=='-') {
                   return 0;
               }
           }
          double value = 0;
          int flag = 1;
          for (int i =0 ;i < characters.size();i++) {
              Character ch = characters.get(i);
              if (ch == '-') {
                  flag = -1;
                  continue;
              } else if (ch == '+'){
                  continue;
              } else {
                  value = value * 10;
              }
              value = value + Integer.parseInt(""+ch);
          }
          value = value * flag;
           if (value > Integer.MAX_VALUE) {
               return Integer.MAX_VALUE;
           } else if (value < Integer.MIN_VALUE) {
               return Integer.MIN_VALUE;
           } else {
               return (int)value;
           }
       }
    }

    public static void main(String[] args) {
        Solution8 stringToInteger = new Solution8();
        System.out.println(stringToInteger.myAtoi("42"));
        System.out.println(stringToInteger.myAtoi("   -42"));
        System.out.println(stringToInteger.myAtoi("4193 with words"));
        System.out.println(stringToInteger.myAtoi("words and 987"));
        System.out.println(stringToInteger.myAtoi("-91283472332"));
        System.out.println(stringToInteger.myAtoi("+-2"));
        System.out.println(stringToInteger.myAtoi("9223372036854775808"));
        System.out.println(stringToInteger.myAtoi("0-1"));
        System.out.println(stringToInteger.myAtoi("-5-"));
        System.out.println(stringToInteger.myAtoi("-13+8"));
    }
}
