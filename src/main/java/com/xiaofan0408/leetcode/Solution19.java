package com.xiaofan0408.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuzefan  2019/11/11 17:33
 */
public class Solution19 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode cur = head;
        int i = 1;
        while (cur != null){
            map.put(i, cur);
            cur = cur.next;
            i++;
        }
        i--;
        Integer index = i - n + 1;
        if (index <= 0) {
            return head;
        }
        Integer preIndex = index - 1;
        if (preIndex <= 0) {
            return head.next;
        }
        ListNode targetNode = map.get(index);
        ListNode preNode = map.get(preIndex);
        preNode.next = targetNode.next;
        return head;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = slow;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        if (fast == null) {
            return head.next;
        }
        while (slow != null && fast != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next;
        }
        pre.next = slow.next;
        return head;
    }

    public static void main(String[] args) {

        ListNode l1_1 = new ListNode(1);
        ListNode l1_2 = new ListNode(2);
        ListNode l1_3 = new ListNode(3);
//        ListNode l1_4 = new ListNode(4);
//        ListNode l1_5 = new ListNode(5);
        l1_1.next = l1_2;
        l1_2.next = l1_3;
//        l1_3.next = l1_4;
//        l1_4.next = l1_5;

        Solution19 solution19 = new Solution19();
        ListNode res = solution19.removeNthFromEnd2(l1_1,3);

        while (res!= null){
            System.out.print(res.val + "->");
            res = res.next;
        }
        System.out.println("null");
    }
}
