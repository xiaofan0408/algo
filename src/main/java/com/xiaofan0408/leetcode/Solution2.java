package com.xiaofan0408.leetcode;

import com.xiaofan0408.util.ListNode;

/**
 * @author xuzefan  2019/7/29 14:07
 */
public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
          ListNode head = new ListNode(0);
          ListNode ans = head;
          int last = 0;
          while (l1 !=null || l2 !=null){
              int val1 = l1 ==null? 0: l1.val;
              int val2 = l2 == null? 0: l2.val;
              head.next = new ListNode((val1 + val2 + last) % 10);
              head = head.next;
              l1 = l1 == null? l1 : l1.next;
              l2 = l2 == null? l2 : l2.next;
              last = (val1 + val2 + last) / 10;
          }
          if (last != 0) {
              head.next = new ListNode(last);
              head = head.next;
          }
          return ans.next;
    }

    public static void main(String[] args) {
        test3();
    }

    public static void test3() {
        Solution2 addTwoNumbers = new Solution2();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        ListNode res = addTwoNumbers.addTwoNumbers(l1,l2);
        while (res!=null) {
            System.out.print(res.val );
            res = res.next;
        }
    }

    public static void test2() {
        Solution2 addTwoNumbers = new Solution2();
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        ListNode res = addTwoNumbers.addTwoNumbers(l1,l2);
        while (res!=null) {
            System.out.print(res.val );
            res = res.next;
        }
    }
    public static void test1() {
        Solution2 addTwoNumbers = new Solution2();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode res = addTwoNumbers.addTwoNumbers(l1,l2);
        while (res!=null) {
            System.out.print(res.val + "->");
            res = res.next;
        }
    }
}
