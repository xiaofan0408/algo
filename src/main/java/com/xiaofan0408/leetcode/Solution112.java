package com.xiaofan0408.leetcode;

/**
 * @author xuzefan  2020/5/28 11:34
 */
public class Solution112 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if (root.val == sum && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
