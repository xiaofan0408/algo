package com.xiaofan0408.leetcode;

public class Solution206 {

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode resverse = reverseList(head.next);
        ListNode temp = head;
        temp.next = null;
        ListNode result = resverse;
        while (resverse.next != null){
            resverse = resverse.next;
        }
        resverse.next = temp;
        return result;
    }
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode prev = null;
        ListNode temp = null;
        while (cur!=null) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
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

//        ListNode res = solution206.reverseList(l1_1);
//
//        while (res!= null){
//            System.out.print(res.val + "->");
//            res = res.next;
//        }
//        System.out.println("null");

        ListNode res2 = solution206.reverseList2(l1_1);

        while (res2!= null){
            System.out.print(res2.val + "->");
            res2 = res2.next;
        }
        System.out.println("null");

    }

}
