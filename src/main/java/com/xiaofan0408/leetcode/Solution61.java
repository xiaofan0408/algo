package com.xiaofan0408.leetcode;

import com.xiaofan0408.util.ListNode;

/**
 * @author xuzefan  2019/11/12 9:59
 */
public class Solution61 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null|| k<=0 ) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        int len = 0;
        ListNode temp = head;
        while (temp != null){
            len ++;
            temp = temp.next;
        }
        for (int i = k % len; i > 0; i--) {
            fast = fast.next;
        }
        while (slow != null && fast.next != null && k % len != 0) {
            slow = slow.next;
            fast = fast.next;
        }
        if (fast.next == null) {
            ListNode result = slow.next;
            slow.next = fast.next;
            fast.next = head;
            return result;
        } else {
            return head;
        }
    }

    public static void main(String[] args) {
        Solution61 solution61 = new Solution61();
        ListNode l1_1 = new ListNode(1);
        ListNode l1_2 = new ListNode(2);
//        ListNode l1_3 = new ListNode(3);
//        ListNode l1_4 = new ListNode(4);
//        ListNode l1_5 = new ListNode(5);
        l1_1.next = l1_2;
//        l1_2.next = l1_3;
//        l1_3.next = l1_4;
//        l1_4.next = l1_5;

        ListNode res = solution61.rotateRight(l1_1,2);

        while (res!= null){
            System.out.print(res.val + "->");
            res = res.next;
        }
        System.out.println("null");
    }
}
