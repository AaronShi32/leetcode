package com.topic.interview;

import com.util.Question;

import java.util.LinkedHashMap;
import java.util.Map;


@Question(id = 145, hint = "LinkedHashMap override 'removeEldestEntry' method")
public class HLRUCache {

    private LinkedHashMap<Integer, Integer> map;

    public HLRUCache(int capacity) {
        int MAX_LENGTH = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > MAX_LENGTH;
            }
        };
    }

    public int get(int key) {
        return map.get(key);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }


}
