package com.xiaofan0408.leetcode;

/**
 * @author xuzefan  2019/11/8 9:55
 */
public class Solution69 {

    public int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }
        long index = 0;
        for (long i =0; i <= x/2;i++) {
            index = i;
            long temp = i * i;
            if (temp > x) {
                return (int)(i - 1);
            } else if (temp ==x){
                return (int) i;
            }
        }
        return (int)index;
    }

    public int mySqrt2(int x) {
        if (x == 1) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        int lo = 1;
        int hi = x / 2;
        int mid = 0;
        while (hi >= lo) {
            mid = (hi + lo) / 2;
            if (mid > x/mid ) {
                hi = mid - 1;
            } else if (x/mid == mid) {
                return mid;
            }
            else {
                if (mid + 1 > x/(mid + 1)) {
                    return mid;
                }
                lo = mid + 1;
            }
        }
       return mid;
    }

    public static void main(String[] args) {
        Solution69 solution69 = new Solution69();
        System.out.println(solution69.mySqrt(1));
        System.out.println(solution69.mySqrt(2));
        System.out.println(solution69.mySqrt(4));
        System.out.println(solution69.mySqrt(8));
        System.out.println(solution69.mySqrt(2147483647));


        System.out.println(solution69.mySqrt2(1));
        System.out.println(solution69.mySqrt2(2));
        System.out.println(solution69.mySqrt2(4));
        System.out.println(solution69.mySqrt2(8));
        System.out.println(solution69.mySqrt2(2147483647));

    }

}
