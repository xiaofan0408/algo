package com.xiaofan0408.swordoffer;

/**
 * @author xuzefan  2019/11/4 13:37
 */
public class Solution6 {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || in == null || pre.length <= 0 || in.length <= 0) {
            return null;
        }
        return reConstructBinaryTree(pre,in,0,pre.length-1,0,in.length-1);
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in,int pre_begin,
                                          int pre_end,int in_begin,int in_end)
    {
        ////前序序列：从pre_begin到pre_end,  中序序列：从in_begin到in_end
        //递归结束条件
        if(pre_begin>pre_end || in_begin>in_end) {
            return null;
        }

        int rootValue=pre[pre_begin];
        TreeNode root=new TreeNode(rootValue);  //第一个节点就是根节点
        if(pre_begin==pre_end || in_begin==in_end) {
            return root;
        }
        //在中序序列中，找到root，前面的就是左子树，右边的就是右子树
        int rootIn=in_begin; //root在中序序列中的位置
        while(rootIn<=in_end && in[rootIn]!=rootValue) {
            rootIn++;
        }

        int left_count=rootIn-in_begin; //左子树节点个数
        root.left=reConstructBinaryTree(pre,in,pre_begin+1,pre_begin+left_count,
                in_begin,rootIn-1);
        root.right=reConstructBinaryTree(pre,in,pre_begin+left_count+1,
                pre_end,rootIn+1,in_end);
        return root;
    }
}
