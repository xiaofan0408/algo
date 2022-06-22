package com.xiaofan0408.leetcode2;

public class Solution152 {

    public int maxProduct(int[] nums) {
//        if (nums.length == 1) {
//            return nums[0];
//        }
//        int max = 0;
//        for (int i = 0; i < nums.length; i++) {
//            int v = nums[i];
//            for (int j = i+ 1 ; j < nums.length; j++) {
//                v = v * nums[j];
//                max = Math.max(max,v);
//            }
//            max = Math.max(max,nums[i]);
//        }
//        return max;
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;

    }

    public static void main(String[] args) {
        Solution152 solution152 = new Solution152();
        System.out.println(solution152.maxProduct(new int[]{0,2}));
    }
}
