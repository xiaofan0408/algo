package com.xiaofan0408.leetcode;

import com.xiaofan0408.util.TreeNode;

/**
 * @author xuzefan  2020/5/28 11:34
 */
public class Solution112 {

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
