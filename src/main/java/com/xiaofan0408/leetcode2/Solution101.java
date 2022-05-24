package com.xiaofan0408.leetcode2;

import com.xiaofan0408.util.TreeNode;
import com.xiaofan0408.util.TreeNodeUtil;


/**
 * @author zefan.xzf
 * @date 2022/5/24 16:53
 */
public class Solution101 {

    public boolean isSymmetric(TreeNode root) {
       if (root == null) {
           return true;
       }
       return isSymmetricTree(root.left,root.right);

    }

    public boolean isSymmetricTree(TreeNode left,TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetricTree(left.left, right.right) && isSymmetricTree(left.right, right.left);
    }


    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.createTree2(new Integer[]{1,0});
        Solution101 solution101 = new Solution101();
        System.out.println(solution101.isSymmetric(root));
    }

}
