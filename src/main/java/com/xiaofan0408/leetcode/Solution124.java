package com.xiaofan0408.leetcode;

import com.xiaofan0408.util.TreeNode;

public class Solution124 {

    public int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        path(root);
        return max;
    }

    public int path(TreeNode root){
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, path(root.left));
        int right = Math.max(0, path(root.right));
        max = Math.max(max,left + right + root.val);
        return Math.max(left,right) + root.val;
    }
}
