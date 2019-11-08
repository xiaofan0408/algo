package com.xiaofan0408.leetcode;

/**
 * @author xuzefan  2019/8/8 11:22
 */
public class Solution9 {

    public boolean isPalindrome(int x) {
        if ( x < 0){
            return false;
        }
        if ( x > 0  && x < 10){
            return true;
        }
        int temp = x;
        int flag = x > 0 ? 1 : -1;
        x = x * flag;
        long result = 0;
        while (x >= 10){
            result = result + x%10;
            x = x / 10;
            result = result * 10;
        }
        result = result + x;
        long res = result * flag;
        return res == temp;
    }

    public static void main(String[] args) {
        Solution9 palindromeNumber9 = new Solution9();
        System.out.println(palindromeNumber9.isPalindrome(121));
        System.out.println(palindromeNumber9.isPalindrome(-121));
        System.out.println(palindromeNumber9.isPalindrome(10));
        System.out.println(palindromeNumber9.isPalindrome(5));
        System.out.println(palindromeNumber9.isPalindrome(11));
    }
}
