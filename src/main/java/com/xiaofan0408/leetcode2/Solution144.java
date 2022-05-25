package com.xiaofan0408.leetcode2;

import com.xiaofan0408.util.TreeNode;
import com.xiaofan0408.util.TreeNodeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zefan.xzf
 * @date 2022/5/25 11:49
 */
public class Solution144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);
        resultList.add(root.val);
        resultList.addAll(left);
        resultList.addAll(right);
        return resultList;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.createTree2(new Integer[]{});
        Solution144 solution144 = new Solution144();
        System.out.println(solution144.preorderTraversal(root));
    }

}
