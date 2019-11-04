package com.xiaofan0408.swordoffer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author xuzefan  2019/11/4 11:37
 */
public class PrintListFromLast {

    static class ListNode{
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        LinkedList<Integer> queue = new LinkedList<>();
        while (listNode != null){
            queue.push(listNode.val);
            listNode = listNode.next;
        }
        return new ArrayList<>(queue);
    }

    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        if (listNode == null) {
            return result;
        }
        printCallBack(result,listNode);
        return result;
    }

    public void printCallBack(ArrayList<Integer> result,ListNode listNode) {
        if (listNode.next != null) {
            printCallBack(result,listNode.next);
            result.add(listNode.val);
        } else {
            result.add(listNode.val);
        }
    }

    public static void main(String[] args) {
//        67,0,24,58
        ListNode node1 = new ListNode(67);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(24);
        ListNode node4 = new ListNode(58);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        PrintListFromLast printListFromLast = new PrintListFromLast();
        ArrayList<Integer> result = printListFromLast.printListFromTailToHead2(node1);
        result.stream().forEach(i -> {
            System.out.println(i);
        });
    }

}
