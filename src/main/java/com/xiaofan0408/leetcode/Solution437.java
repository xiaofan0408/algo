package com.xiaofan0408.leetcode;

import com.xiaofan0408.util.TreeNode;
import com.xiaofan0408.util.TreeNodeUtil;

/**
 * @author xuzefan  2020/5/28 17:22
 */
public class Solution437 {

    public int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        int curr = path(root,sum);
        int left = pathSum(root.left,sum);
        int right =  pathSum(root.right,sum);
        return curr + left + right;
    }

    public int path(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        if (root.val == sum) {
            return 1 + path(root.left, sum - root.val) + path(root.right,sum - root.val);
        }
        return path(root.left, sum - root.val) + path(root.right,sum - root.val);
    }

    public static void main(String[] args) {
        Solution437 solution437 = new Solution437();
        TreeNode treeNode = TreeNodeUtil.createTree(new Integer[]{10,5,-3,3,2,null,11,3,-2,null,1});
        System.out.println(solution437.pathSum(treeNode,8));
    }
}
