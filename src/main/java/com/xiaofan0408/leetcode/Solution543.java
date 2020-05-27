package com.xiaofan0408.leetcode;

public class Solution543 {

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
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxDepth(root);
        return max;
    }

    public int maxDepth(TreeNode treeNode){
        if (treeNode == null){
            return 0;
        }
        int left = maxDepth(treeNode.left);
        int right = maxDepth(treeNode.right);
        max = Math.max(left + right,max);
        return 1 + Math.max(left,right);
    }

}
