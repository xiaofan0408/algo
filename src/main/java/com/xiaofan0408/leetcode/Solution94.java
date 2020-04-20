package com.xiaofan0408.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuzefan  2020/4/20 13:55
 */
public class Solution94 {


      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          public TreeNode(int x) { val = x; }
      }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root,result);
        return result;
    }

    private void traverse(TreeNode root, List<Integer> result) {
          if (root != null) {
              traverse(root.left,result);
              result.add(root.val);
              traverse(root.right,result);
          }
    }


    public static void main(String[] args) {
        Solution94 solution94 = new Solution94();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node2.left = node3;
        node1.right = node2;
        System.out.println(solution94.inorderTraversal(node1));
    }
}
