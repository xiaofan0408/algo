package com.xiaofan0408.leetcode2;

import com.xiaofan0408.util.TreeNode;
import com.xiaofan0408.util.TreeNodeUtil;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author zefan.xzf
 * @date 2022/5/26 11:55
 */
public class Solution501 {

    int preVal = 0, curTimes = 0, maxTimes = 0;
    ArrayList<Integer> list = new ArrayList<Integer>();
    public int[] findMode(TreeNode root) {
        traversal(root);
        //list转换为int[]
        int size = list.size();
        int[] ans = new int[size];
        for(int i = 0; i < size; i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
    //二叉搜索树中序遍历是递增顺序
    public void traversal(TreeNode root){
        if(root != null){
            traversal(root.left);
            //判断当前值与上一个值的关系, 更新 curTimes 和 preVal
            if(preVal == root.val){
                curTimes++;
            }else{
                preVal = root.val;
                curTimes = 1;
            }
            //判断当前数量与最大数量的关系, 更新 list 和 maxTimes
            if(curTimes == maxTimes){
                list.add(root.val);
            }else if(curTimes > maxTimes){
                list.clear();
                list.add(root.val);
                maxTimes = curTimes;
            }
            traversal(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtil.createTree2(new Integer[]{1,null,2,2});
        Solution501 solution501 = new Solution501();
        System.out.println(Arrays.toString(solution501.findMode(root)));
    }


}
