package com.java.grammer.collections;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class MapMain {

    // private static LinkedHashMap<Integer, Character> map = new LinkedHashMap<>(16, 0.75f, false);

    private static HashMap<Integer, Character> map = new HashMap<>();

    // private static TreeMap<Integer, Character> map = new TreeMap<>();

    private static ConcurrentHashMap<Integer, Character> cmap = new ConcurrentHashMap<>();

    public static void main(String[] args){
        char curValue = map.put(1, 'x');
        // curValue is null because key 1 is putted firstly
        char oldValue = map.put(1, 'j');
        System.out.println(oldValue);
        map.put(2, 'y');
        map.put(0, 'z');
        map.put(5, 'j');
        map.put(3, 'm');
        map.put(-1, 'o');
        map.put(4, 'k');
        map.get(5);
        System.out.println(map.keySet());
    }
}
