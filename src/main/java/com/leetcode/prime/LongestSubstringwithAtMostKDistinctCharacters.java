package com.leetcode.prime;


import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtMostKDistinctCharacters {

    public static int PRATICE(String s, int K) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int start = 0, max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            }else{
                map.put(c, 1);
                if(map.size() > K){
                    char sc = s.charAt(start ++);
                    int count = map.get(sc);
                    if(count > 1){
                        map.put(sc, count - 1);
                    }else{
                        map.remove(sc);
                    }
                }
                max = Math.max(max, i - start + 1);
            }
        }
        return max;
    }


    public static int LSDK(String s, int K) {
        int start = 0, max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
                while (map.size() > K) {
                    char startChar = s.charAt(start++);
                    int count = map.get(startChar);
                    if (count > 1) {
                        map.put(startChar, count - 1);
                    } else {
                        map.remove(startChar);
                    }
                }
                max = Math.max(max, i - start + 1);
            }
        }
        return max;
    }
}
