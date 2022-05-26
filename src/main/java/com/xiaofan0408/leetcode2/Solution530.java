package com.xiaofan0408.leetcode2;

import com.xiaofan0408.util.TreeNode;
import com.xiaofan0408.util.TreeNodeUtil;

/**
 * @author zefan.xzf
 * @date 2022/5/26 15:06
 */
public class Solution530 {

    int min = Integer.MAX_VALUE;
    int preValue = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }
        inOrder(root);
        return min;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        int temp = root.val - preValue;
        min = Math.min(Math.abs(temp), min);
        preValue = root.val;
        inOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.createTree2(new Integer[]{236,104,701,null,227,null,911});
        Solution530 solution530 = new Solution530();
        System.out.println(solution530.getMinimumDifference(root));
    }
}
