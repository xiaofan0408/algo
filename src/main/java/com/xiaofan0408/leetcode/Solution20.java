package com.xiaofan0408.leetcode;

import java.util.LinkedList;

/**
 * @author xuzefan  2019/8/8 13:44
 */
public class Solution20 {

    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        if (s.length()== 1) {
            return false;
        }
        LinkedList<Character> parentheses = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                parentheses.push(ch);
            }

            switch (ch){
                case ')':{
                    Character c = parentheses.poll();
                    if (c == null || c != '(') {
                        return false;
                    }
                    break;
                }
                case ']':{
                    Character c = parentheses.poll();
                    if (c == null ||c != '[') {
                        return false;
                    }
                    break;
                }
                case '}':{
                    Character c = parentheses.poll();
                    if (c == null || c != '{') {
                        return false;
                    }
                    break;
                }
                default:{}
            }
        }
        return parentheses.size() == 0;
    }

    public static void main(String[] args) {
        Solution20 validParentheses = new Solution20();
        System.out.println(validParentheses.isValid("()"));
        System.out.println(validParentheses.isValid("()[]{}"));
        System.out.println(validParentheses.isValid("(]"));
        System.out.println(validParentheses.isValid("([)]"));
        System.out.println(validParentheses.isValid("{[]}"));
        System.out.println(validParentheses.isValid("]}"));
    }
}
