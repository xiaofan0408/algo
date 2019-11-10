package com.xiaofan0408.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution141 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean hasCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null){
            if (set.contains(head)) {
                return true;
            } else{
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
