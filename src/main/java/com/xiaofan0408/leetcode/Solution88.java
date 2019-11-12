package com.xiaofan0408.leetcode;

/**
 * @author xuzefan  2019/11/12 13:53
 */
public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = nums1.length -1;
        int i = m - 1;
        int j = n - 1;
        while (i > -1 && j > -1) {
            if (nums1[i] >= nums2[j]) {
                nums1[len] = nums1[i];
                i--;
            } else {
                nums1[len] = nums2[j];
                j--;
            }
            len--;
        }
        while ( j > -1){
            nums1[len] = nums2[j];
            len--;
            j--;
        }
    }

    public static void main(String[] args) {
        Solution88 solution88 = new Solution88();
        int[] num1 = new int[]{1,2,3,0,0,0};
        int[] num2 = new int[]{2,5,6};
        solution88.merge(num1,3,num2,3);
        for (int n:num1) {
            System.out.print(n);
        }
    }
}
