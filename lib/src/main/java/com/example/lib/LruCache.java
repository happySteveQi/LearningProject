package com.example.lib;

import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache extends LinkedHashMap<Integer, Integer> {
    private final int MAX_SIZE;

    public LruCache(int capacity) {
        super(capacity, (float) 0.75, true);
        this.MAX_SIZE = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> entry) {
        return size() > MAX_SIZE;//removeEldestEntry(entry);
    }

    public int get(int key) {
        if (super.get(key) == null) return -1;
        return super.get(key);
    }
}
