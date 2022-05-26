package com.xiaofan0408.leetcode2;

import com.xiaofan0408.util.TreeNode;
import com.xiaofan0408.util.TreeNodeUtil;

/**
 * @author zefan.xzf
 * @date 2022/5/26 17:55
 */
public class Solution572 {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return dfs(s, t);
    }

    public boolean dfs(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        return check(s, t) || dfs(s.left, t) || dfs(s.right, t);
    }

    public boolean check(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.val != t.val) {
            return false;
        }
        return check(s.left, t.left) && check(s.right, t.right);
    }


    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.createTree2(new Integer[]{3,4,5,1,2});
        TreeNode subRoot = TreeNodeUtil.createTree2(new Integer[]{4,1,2});
        Solution572 solution572 = new Solution572();
        System.out.println(solution572.isSubtree(root,subRoot));
    }

}
