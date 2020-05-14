package com.xiaofan0408.leetcode;

/**
 * @author xuzefan  2020/5/14 17:05
 */
public class Solution110 {
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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean cur =  Math.abs(depth(root.left)-depth(root.right)) > 1?false:true;
        return cur && isBalanced(root.left) && isBalanced(root.right);
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = depth(root.left);
        int r = depth(root.right);
        return 1 + Math.max(l,r);
    }
}
