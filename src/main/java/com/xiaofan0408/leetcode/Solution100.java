package com.xiaofan0408.leetcode;

import com.xiaofan0408.util.TreeNode;

/**
 * @author xuzefan  2020/7/28 18:12
 */
public class Solution100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if ((p == null && q != null)||(p != null & q == null)) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
