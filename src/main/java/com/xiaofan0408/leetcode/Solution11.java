package com.xiaofan0408.leetcode;

/**
 * @author xuzefan  2019/11/8 17:18
 */
public class Solution11 {
    public int maxArea(int[] height) {
        int lo = 0;
        int hi = height.length - 1;
        int max = 0;
        while (hi > lo){
            int area = calcArea(height[lo],height[hi],hi - lo);
            if (max < area) {
                max = area;
            }
            if (height[lo] > height[hi]) {
                hi = hi -1;
            } else {
                lo = lo + 1;
            }
        }
        return max;
    }

    private int calcArea(int loV,int hiV,int length){
        return loV > hiV ? hiV * length : loV * length;
    }

    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        System.out.println(solution11.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
