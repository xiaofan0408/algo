package com.xiaofan0408.leetcode2;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution146 {

    static class LRUCache extends LinkedHashMap<Integer,Integer> {

        private int cacheSize;

        public LRUCache(int capacity) {
            super(capacity, 0.75f, true);
            this.cacheSize = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key,value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > cacheSize;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
    }

}
