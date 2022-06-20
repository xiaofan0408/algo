package com.xiaofan0408.leetcode2;

import com.xiaofan0408.util.ListNode;

public class Solution25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode first = head;
        for (int i=0;i <k;i++) {
            if (cur == null) {
                return head;
            }
            cur = cur.next;
        }
        ListNode newHead = reverse(first,cur);
        ListNode nextEnd = newHead;
        while (nextEnd.next!=null){
            nextEnd = nextEnd.next;
        }
        nextEnd.next = reverseKGroup(cur,k);
        return newHead;
    }


    private ListNode reverse(ListNode first, ListNode end) {
        ListNode cur = first;
        ListNode pre = null;
        while (cur != end){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    public static void main(String[] args) {
        Solution25 solution25 = new Solution25();
        ListNode l1_1 = new ListNode(1);
        ListNode l1_2 = new ListNode(2);
        ListNode l1_3 = new ListNode(3);
        ListNode l1_4 = new ListNode(4);
        ListNode l1_5 = new ListNode(5);
        l1_1.next = l1_2;
        l1_2.next = l1_3;
        l1_3.next = l1_4;
        l1_4.next = l1_5;

        ListNode res2 = solution25.reverseKGroup(l1_1,2);
        while (res2!= null){
            System.out.print(res2.val + "->");
            res2 = res2.next;
        }
        System.out.println("null");
    }

}
