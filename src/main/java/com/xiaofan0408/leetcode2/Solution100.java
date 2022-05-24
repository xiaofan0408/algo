package com.xiaofan0408.leetcode2;

import com.xiaofan0408.util.TreeNode;
import com.xiaofan0408.util.TreeNodeUtil;

/**
 * @author zefan.xzf
 * @date 2022/5/24 16:41
 */
public class Solution100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null && q!= null) {
            return false;
        }
        if (p != null && q== null) {
            return false;
        }
        boolean rootTree = p.val == q.val;
        if (!rootTree ) {
            return false;
        }
        boolean leftTree = isSameTree(p.left,q.left);
        boolean rightTree = isSameTree(p.right, q.right);
        return leftTree && rightTree;

    }

    public static void main(String[] args) {
        TreeNode left = TreeNodeUtil.createTree2(new Integer[]{1,2,1});
        TreeNode right = TreeNodeUtil.createTree2(new Integer[]{1,1,2});
        Solution100 solution100 = new Solution100();
        System.out.println(solution100.isSameTree(left,right));
    }


}
