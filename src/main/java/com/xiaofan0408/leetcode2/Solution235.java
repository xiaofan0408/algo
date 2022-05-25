package com.xiaofan0408.leetcode2;

import com.xiaofan0408.leetcode.Solution2;
import com.xiaofan0408.util.TreeNode;
import com.xiaofan0408.util.TreeNodeUtil;

/**
 * @author zefan.xzf
 * @date 2022/5/25 12:14
 */
public class Solution235 {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ((root.val - p.val) * (root.val - q.val) <= 0) {
            return root;
        }
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p,q);
        } else {
            return lowestCommonAncestor(root.right, p , q);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.createTree2(new Integer[]{6,2,8,0,4,7,9,null,null,3,5});
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(4);
        Solution235 solution235 = new Solution235();
        TreeNode result = solution235.lowestCommonAncestor(root,p,q);
        System.out.println(result);
    }

}
