package com.xiaofan0408.leetcode;

import com.xiaofan0408.util.ListNode;

/**
 * @author xuzefan  2019/11/11 15:23
 */
public class Solution147 {


    public ListNode insertionSortList(ListNode head) {
        ListNode dummy  = new ListNode(-1);
        ListNode cur = head;
        ListNode pre = dummy;

        while (cur != null){
            ListNode tmp = cur.next;
            while (pre.next != null && pre.next.val < cur.val){
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            pre = dummy;
            cur = tmp;
        }
        return dummy.next;
    }

}
