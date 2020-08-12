package com.xiaofan0408.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author xuzefan  2020/8/12 11:49
 */
public class Solution146 {

    static class LRUCache {

        private int capacity;

        private int size;

        private Map<Integer,Integer> dataMap = new HashMap<>();

        private LinkedList<Integer> linkedList = new LinkedList<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
        }

        public int get(int key) {
            Integer value = dataMap.get(key);
            if (value == null) {
                return -1;
            }
            linkedList.remove((Object)key);
            linkedList.addFirst(key);
            return value;
        }

        public void put(int key, int value) {
            if (dataMap.containsKey(key)) {
                dataMap.put(key,value);
                linkedList.remove((Object)key);
                linkedList.addFirst(key);
            } else {
                if (size + 1 > capacity) {
                    Integer last = linkedList.removeLast();
                    dataMap.remove(last);
                    size--;
                }
                dataMap.put(key,value);
                linkedList.addFirst(key);
                size++;
            }
        }
    }

    public static void main(String[] args) {
        // ["LRUCache","get","put","get","put","put","get","get"]
        //[[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]

        LRUCache cache = new LRUCache( 2  );
        cache.get(2);
        cache.put(2,6);
        cache.get(1);
        cache.put(1,5);
        cache.put(1,2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
