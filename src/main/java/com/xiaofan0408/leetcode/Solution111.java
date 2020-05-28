package com.xiaofan0408.leetcode;

import com.xiaofan0408.util.TreeNode;

/**
 * @author xuzefan  2020/5/28 18:14
 */
public class Solution111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        if (l == 0 && r !=0 ) {
            return r + 1;
        }
        if (r == 0 && l!=0) {
            return l + 1;
        }
        return 1 + Math.min(l,r);
    }
}
