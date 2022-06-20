package com.xiaofan0408.leetcode2;

import com.xiaofan0408.util.ListNode;

public class Solution206 {

    public ListNode reverseList(ListNode head) {

        ListNode cur = head;
        ListNode pre = null;

        while (cur != null){

            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;

        }
        return pre;
    }

    public static void main(String[] args) {
        Solution206 solution206 = new Solution206();
        ListNode l1_1 = new ListNode(1);
        ListNode l1_2 = new ListNode(2);
        ListNode l1_3 = new ListNode(3);
        ListNode l1_4 = new ListNode(4);
        ListNode l1_5 = new ListNode(5);
        l1_1.next = l1_2;
        l1_2.next = l1_3;
        l1_3.next = l1_4;
        l1_4.next = l1_5;

        ListNode res = solution206.reverseList(l1_1);

        while (res!= null){
            System.out.print(res.val + "->");
            res = res.next;
        }
        System.out.println("null");
    }

}
