package com.xiaofan0408.other;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xuzefan  2019/7/29 14:01
 */
public class LRUCache<K,V> extends LinkedHashMap<K,V> {

    private int cacheSize;

    public LRUCache(int cacheSize) {
        super(16, 0.75f, true);
        this.cacheSize = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() >= cacheSize;
    }

}

