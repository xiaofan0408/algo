package com.xiaofan0408.leetcode;

import com.xiaofan0408.util.ListNode;

/**
 * @author xuzefan  2020/8/12 11:33
 */
public class Solution206_2 {
    public ListNode reverseList(ListNode head) {
        ListNode currnt = head;
        ListNode prev= null;
        ListNode next;
        while (currnt != null){
            next = currnt.next;
            currnt.next = prev;
            prev = currnt;
            currnt = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Solution206_2 solution206_2 = new Solution206_2();
        ListNode l1_1 = new ListNode(1);
        ListNode l1_2 = new ListNode(2);
        ListNode l1_3 = new ListNode(3);
        ListNode l1_4 = new ListNode(4);
        ListNode l1_5 = new ListNode(5);
        l1_1.next = l1_2;
        l1_2.next = l1_3;
        l1_3.next = l1_4;
        l1_4.next = l1_5;

        ListNode res2 = solution206_2.reverseList(l1_1);
        while (res2!= null){
            System.out.print(res2.val + "->");
            res2 = res2.next;
        }
        System.out.println("null");
    }
}
