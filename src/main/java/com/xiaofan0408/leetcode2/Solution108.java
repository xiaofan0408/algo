package com.xiaofan0408.leetcode2;

import com.xiaofan0408.util.TreeNode;

import java.util.Arrays;

/**
 * @author zefan.xzf
 * @date 2022/5/24 18:04
 */
public class Solution108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        if (nums.length == 0) {
            return null;
        }
        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode left = sortedArrayToBST(Arrays.copyOfRange(nums, 0,mid));
        TreeNode right = sortedArrayToBST(Arrays.copyOfRange(nums,mid + 1, nums.length));
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        Solution108 solution108 = new Solution108();
        TreeNode node = solution108.sortedArrayToBST(new int[]{1,3});
        System.out.println(node);
    }

}
