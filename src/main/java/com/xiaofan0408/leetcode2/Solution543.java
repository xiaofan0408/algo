package com.xiaofan0408.leetcode2;

import com.xiaofan0408.util.TreeNode;
import com.xiaofan0408.util.TreeNodeUtil;

/**
 * @author zefan.xzf
 * @date 2022/5/26 16:07
 */
public class Solution543 {

    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxDepth(root);
        return max;
    }

    public int maxDepth(TreeNode treeNode){
        if (treeNode == null){
            return 0;
        }
        int left = maxDepth(treeNode.left);
        int right = maxDepth(treeNode.right);
        max = Math.max(left + right,max);
        return 1 + Math.max(left,right);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.createTree2(new Integer[]{1,2,3,4,5});
        Solution543 solution543 = new Solution543();
        System.out.println(solution543.diameterOfBinaryTree(root));
    }

}
