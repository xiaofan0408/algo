package com.xiaofan0408.leetcode2;

import com.xiaofan0408.util.ListNode;


import java.util.HashSet;
import java.util.Set;

public class Solution160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> map = new HashSet<>();
        ListNode temp = headA;
        while (temp != null){
            map.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null){
            if (map.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public static void main(String[] args) {
        Solution160 solution160 = new Solution160();
    }

}
