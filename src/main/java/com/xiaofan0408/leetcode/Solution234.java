package com.xiaofan0408.leetcode;

import com.xiaofan0408.util.ListNode;

/**
 * @author xuzefan  2019/12/16 18:08
 */
public class Solution234 {


    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode next;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (slow.val != pre.val) {
                return false;
            }
            slow = slow.next;
            pre = pre.next;
        }

        return true;
    }


}
