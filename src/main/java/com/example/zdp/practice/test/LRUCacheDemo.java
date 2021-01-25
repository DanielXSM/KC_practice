package com.example.zdp.practice.test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName LRUCacheDemo
 * @Author dongping
 * @Date 2021/1/25 14:25
 * @Description LRUCacheDemo
 * @Version 1.0
 */
public class LRUCacheDemo<K,V> extends LinkedHashMap<K,V> {

    private int capacity;//缓存坑位

    public LRUCacheDemo(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size()>capacity;
    }

    
    public static void main(String[] args) {

    }
}
