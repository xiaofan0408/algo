package com.xiaofan0408.leetcode;

public class Solution24 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
       ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode next = pre;
        while (pre.next!= null && pre.next.next != null) {
            ListNode a = pre.next;
            ListNode b = a.next;
            ListNode tmp= b.next;
            pre.next = b;
            b.next = a;
            a.next = tmp;
            pre = a;
        }
        return next.next;
    }

    public static void main(String[] args) {
        Solution24 solution24 = new Solution24();
        ListNode l1_1 = new ListNode(1);
        ListNode l1_2 = new ListNode(2);
        ListNode l1_3 = new ListNode(3);
        ListNode l1_4 = new ListNode(4);
        l1_1.next = l1_2;
        l1_2.next = l1_3;
        l1_3.next = l1_4;

        ListNode res = solution24.swapPairs(l1_1);

        while (res!= null){
            System.out.print(res.val + "->");
            res = res.next;
        }
        System.out.println("null");


    }

}
