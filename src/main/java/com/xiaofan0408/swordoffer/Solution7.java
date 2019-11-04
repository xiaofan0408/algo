package com.xiaofan0408.swordoffer;

import java.util.Stack;

/**
 * @author xuzefan  2019/11/4 15:39
 */
public class Solution7 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
      stack1.push(node);
    }

    public int pop() throws Exception {
        if (stack2.size() <= 0) {
            if (stack1.size() > 0) {
                int length = stack1.size();
                for(int i= 0;i < length;i++) {
                    stack2.push(stack1.pop());
                }
            }
        }
        if (stack2.size() == 0) {
            throw new Exception("queue is empty");
        }
        return stack2.pop();
    }
}
