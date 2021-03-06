package com.xiaofan0408.leetcode;

import com.xiaofan0408.util.TreeNode;

/**
 * @author xuzefan  2020/5/15 11:36
 */
public class Solution226 {

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }

}
