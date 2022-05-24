package com.xiaofan0408.leetcode2;

import com.xiaofan0408.util.TreeNode;
import com.xiaofan0408.util.TreeNodeUtil;

/**
 * @author zefan.xzf
 * @date 2022/5/24 18:26
 */
public class Solution110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftLen = findLen(root.left);
        int rightLen = findLen(root.right);
        if (Math.abs(leftLen - rightLen) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int findLen(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = findLen(node.left);
        int right = findLen(node.right);
        return 1 + Math.max(left,right);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.createTree2(new Integer[]{1,2,2,3,3,null,null,4,4});
        Solution110 solution110 = new Solution110();
        System.out.println(solution110.isBalanced(root));
    }

}
