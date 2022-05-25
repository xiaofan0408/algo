package com.xiaofan0408.leetcode2;

import com.xiaofan0408.util.TreeNode;
import com.xiaofan0408.util.TreeNodeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zefan.xzf
 * @date 2022/5/25 11:49
 */
public class Solution145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        List<Integer> left = postorderTraversal(root.left);
        List<Integer> right = postorderTraversal(root.right);
        resultList.addAll(left);
        resultList.addAll(right);
        resultList.add(root.val);
        return resultList;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.createTree2(new Integer[]{1,null,2,3});
        Solution145 solution145 = new Solution145();
        System.out.println(solution145.postorderTraversal(root));
    }

}
