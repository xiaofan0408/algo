package com.xiaofan0408.leetcode2;

import com.xiaofan0408.util.TreeNode;
import com.xiaofan0408.util.TreeNodeUtil;

/**
 * @author zefan.xzf
 * @date 2022/5/24 15:56
 */
public class Solution965 {

    public boolean isUnivalTree(TreeNode root) {
        if (root == null){
            return true;
        }
        int val = root.val;
        boolean leftTree = true;
        boolean rightTree = true;
        if (root.left != null) {
            leftTree = root.left.val == val;
        }
        if (root.right != null) {
            rightTree = root.right.val == val;
        }
        return leftTree && rightTree && isUnivalTree(root.left) && isUnivalTree(root.right);

    }


    public static void main(String[] args) {
        TreeNode node = TreeNodeUtil.createTree(new Integer[]{2,2,2,5,2});
        Solution965 solution965 = new Solution965();
        boolean result = solution965.isUnivalTree(node);
        System.out.println(result);
    }
}
