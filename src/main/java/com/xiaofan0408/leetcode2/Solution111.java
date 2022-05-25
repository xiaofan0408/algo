package com.xiaofan0408.leetcode2;

import com.xiaofan0408.util.TreeNode;
import com.xiaofan0408.util.TreeNodeUtil;

/**
 * @author zefan.xzf
 * @date 2022/5/25 10:37
 */
public class Solution111 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (root.left == null || root.right == null) {
            return 1 + Math.max(left,right);
        } else {
            return 1 + Math.min(left,right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.createTree2(new Integer[]{3,9,20,null,null,15,7});
        Solution111 solution111 = new Solution111();
        System.out.println( solution111.minDepth(root));
    }

}
