package com.xiaofan0408.leetcode2;

import com.xiaofan0408.util.TreeNode;
import com.xiaofan0408.util.TreeNodeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zefan.xzf
 * @date 2022/5/25 12:30
 */
public class Solution257 {

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<String> resultList = new ArrayList<>();
        if (root.left == null && root.right == null) {
            resultList.add(root.val + "");
            return resultList;
        }
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        resultList.addAll(left);
        resultList.addAll(right);

        for (int i=0;i < resultList.size();i++) {
            String temp = resultList.get(i);
            resultList.set(i, root.val + "->" + temp);
        }
        return resultList;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.createTree2(new Integer[]{1});
        Solution257 solution257 = new Solution257();
        System.out.println(solution257.binaryTreePaths(root));
    }

}
