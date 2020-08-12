package com.xiaofan0408.leetcode;

import java.util.PriorityQueue;

/**
 * @author xuzefan  2020/8/12 16:45
 */
public class Solution215 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num: nums) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }

}
