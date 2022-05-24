package com.xiaofan0408.leetcode2;

import com.xiaofan0408.util.TreeNode;
import com.xiaofan0408.util.TreeNodeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zefan.xzf
 * @date 2022/5/24 16:20
 */
public class Solution94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> resultList = new ArrayList<>();
        List<Integer> leftList = inorderTraversal(root.left);
        List<Integer> rightList = inorderTraversal(root.right);
        resultList.addAll(leftList);
        resultList.add(root.val);
        resultList.addAll(rightList);
        return resultList;
    }


    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.createTree2(new Integer[]{1,null,2,3});
        Solution94 solution94 = new Solution94();
        List<Integer> resultList = solution94.inorderTraversal(root);
        System.out.println(resultList);
    }

}
