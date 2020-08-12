package com.xiaofan0408.leetcode;

import com.xiaofan0408.util.TreeNode;

/**
 * @author xuzefan  2020/8/12 11:02
 */
public class Solution124_2 {

    private int max = Integer.MIN_VALUE;;

    public int maxPathSum(TreeNode root) {
        maxDepth(root);
        return max;
    }

    public int maxDepth(TreeNode node){
        if (node == null) {
            return 0;
        }
        int left = Math.max(0,maxDepth(node.left));
        int right = Math.max(0,maxDepth(node.right));
        int sum = node.val + left + right;
        if (sum > max) {
            max = sum;
        }
        return Math.max(left,right) + node.val;
    }
}
