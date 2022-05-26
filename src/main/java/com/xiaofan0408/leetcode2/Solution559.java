package com.xiaofan0408.leetcode2;

import com.xiaofan0408.util.Node;

/**
 * @author zefan.xzf
 * @date 2022/5/26 16:21
 */
public class Solution559 {

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.children == null || root.children.isEmpty()) {
            return 1;
        }
        int max = 0;
        int a;
        for (Node c: root.children) {
            a = maxDepth(c);
            max = Math.max(a  ,max );
        }
        return max;
    }
}
