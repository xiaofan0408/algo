package com.xiaofan0408.leetcode;

/**
 * @author xuzefan  2019/11/12 10:34
 */
public class Solution83 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur = head;
        ListNode next = cur.next;
        while ( next != null) {
            if (cur.val == next.val) {
                cur.next = next.next;
                next = cur.next;
            } else {
                cur = cur.next;
                next = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Solution83 solution83 = new Solution83();
        ListNode l1_1 = new ListNode(1);
        ListNode l1_2 = new ListNode(2);
        ListNode l1_3 = new ListNode(2);
        ListNode l1_4 = new ListNode(3);
        ListNode l1_5 = new ListNode(3);
        l1_1.next = l1_2;
        l1_2.next = l1_3;
        l1_3.next = l1_4;
        l1_4.next = l1_5;

        ListNode res = solution83.deleteDuplicates(l1_1);

        while (res!= null){
            System.out.print(res.val + "->");
            res = res.next;
        }
        System.out.println("null");
    }

}
