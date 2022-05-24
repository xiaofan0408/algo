package com.xiaofan0408.leetcode2;

import com.xiaofan0408.util.TreeNode;
import com.xiaofan0408.util.TreeNodeUtil;

/**
 * @author zefan.xzf
 * @date 2022/5/24 17:55
 */
public class Solution104 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);
        return 1 + Math.max(maxLeft,maxRight);
    }


    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.createTree2(new Integer[]{3,9,20,null,null,15,7});
        Solution104 solution104 = new Solution104();
        System.out.println(solution104.maxDepth(root));
    }

}
