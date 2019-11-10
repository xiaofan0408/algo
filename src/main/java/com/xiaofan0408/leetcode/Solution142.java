package com.xiaofan0408.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution142 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null){
            if (set.contains(head)) {
                return head;
            } else{
                set.add(head);
            }
            head = head.next;
        }
        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode slow2 = head;
                while (slow2 != slow){
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }
}
