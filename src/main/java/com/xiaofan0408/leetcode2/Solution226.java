package com.xiaofan0408.leetcode2;

import com.xiaofan0408.util.TreeNode;
import com.xiaofan0408.util.TreeNodeUtil;

/**
 * @author zefan.xzf
 * @date 2022/5/25 12:01
 */
public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNodeUtil.createTree2(new Integer[]{2,1,3});
        Solution226 solution226 = new Solution226();
        TreeNode result = solution226.invertTree(treeNode);
        System.out.println(result);
    }
}
