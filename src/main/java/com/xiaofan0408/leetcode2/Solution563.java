package com.xiaofan0408.leetcode2;

import com.xiaofan0408.util.TreeNode;
import com.xiaofan0408.util.TreeNodeUtil;

/**
 * @author zefan.xzf
 * @date 2022/5/26 17:21
 */
public class Solution563 {

    public int findTilt(TreeNode root) {
        if (root== null) {
            return 0;
        }
        int leftVal = sumTree(root.left);
        int rightVal = sumTree(root.right);
        int rootTilt = Math.abs(leftVal - rightVal);
        return rootTilt + findTilt(root.left) + findTilt(root.right);
    }

    private int sumTree(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.val + sumTree(node.left) + sumTree(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.createTree2(new Integer[]{21,7,14,1,1,2,2,3,3});
        Solution563 solution563 = new Solution563();
        System.out.println(solution563.findTilt(root));
    }

}
