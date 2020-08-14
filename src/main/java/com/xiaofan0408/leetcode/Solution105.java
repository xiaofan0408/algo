package com.xiaofan0408.leetcode;

import com.xiaofan0408.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuzefan  2020/8/13 10:01
 */
public class Solution105 {

    //preorder = [3,9,20,15,7]
    //inorder = [9,3,15,20,7]

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return myBuildTree(preorder,inorder,0,preorder.length-1,0,inorder.length-1,map);
    }

    public TreeNode myBuildTree(int[] preorder, int[] inorder,int pStart,int pEnd,int iStart,int iEnd, Map<Integer,Integer> map){
        if (pStart>pEnd || iStart>iEnd) {
            return null;
        }
        int root = preorder[pStart];
        int iRoot = map.get(root);
        TreeNode node = new TreeNode();
        node.val = root;
        int lLen = iRoot - iStart;
        int rLen = iEnd - iRoot;
        node.left = myBuildTree(preorder,inorder,pStart + 1,pStart + lLen,iStart,iRoot - 1,map);
        node.right = myBuildTree(preorder,inorder,pStart+lLen+1,pStart+lLen+rLen,iRoot + 1,iEnd,map);
        return node;
    }

    public static void main(String[] args) {
        int[] p = new int[]{3,9,20,15,7};
        int[] in = new int[]{9,3,15,20,7};
        Solution105 solution105 = new Solution105();
        TreeNode node = solution105.buildTree(p,in);
        System.out.println(node);
    }
}
