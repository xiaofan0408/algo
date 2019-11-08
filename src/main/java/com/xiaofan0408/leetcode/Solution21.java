package com.xiaofan0408.leetcode;

/**
 * @author xuzefan  2019/8/8 15:39
 */




public class Solution21 {
    static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode result = new ListNode(0);
        ListNode head = result;
        while (l1!=null && l2 != null){
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if (l1!=null) {
            head.next = l1;
        }
        if (l2!=null) {
            head.next = l2;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1_1 = new ListNode(1);
        ListNode l1_2 = new ListNode(2);
        ListNode l1_3 = new ListNode(4);
        l1_1.next = l1_2;
        l1_2.next = l1_3;

        ListNode l2_1 = new ListNode(1);
        ListNode l2_2 = new ListNode(3);
        ListNode l2_3 = new ListNode(4);
        l2_1.next = l2_2;
        l2_2.next = l2_3;
        Solution21 mergeTwoSortedList = new Solution21();
        ListNode res = mergeTwoSortedList.mergeTwoLists(l1_1,l2_1);
        while (res!=null) {
            System.out.print(res.val );
            res = res.next;
        }
    }
}
