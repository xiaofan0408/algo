package com.xiaofan0408.leetcode2;

import com.xiaofan0408.util.TreeNode;
import com.xiaofan0408.util.TreeNodeUtil;

import java.util.*;

public class Solution103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> nodeList = new LinkedList<>();
        nodeList.add(root);
        boolean isLeft = false;
        while (!nodeList.isEmpty()){
            int size = nodeList.size();
            Integer[] res = new Integer[size];
            for (int i=0; i< size; i++) {
                TreeNode node = nodeList.poll();
                res[isLeft? size - i -1: i] =  node.val;
                if (node.left != null) {
                    nodeList.offer(node.left);
                }
                if (node.right != null) {
                    nodeList.offer(node.right);
                }
            }
            result.add(Arrays.asList(res));
            isLeft = !isLeft;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.createTree2(new Integer[]{3,9,20,null,null,15,7});
        Solution103 solution103 = new Solution103();
        System.out.println(solution103.zigzagLevelOrder(root));
    }

}
