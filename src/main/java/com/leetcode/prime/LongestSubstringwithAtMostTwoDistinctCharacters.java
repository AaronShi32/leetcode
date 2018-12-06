package com.leetcode.prime;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtMostTwoDistinctCharacters {

    public static int SELF(String s, int K){
        return 0;
    }


    public static int PRATICE(String s, int K) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int max = 0, start = 0;
        Map<Character, Integer> map = new HashMap<>(); // 字符 - 索引
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.size() == 2 && !map.containsKey(c)){
                int li = s.length();
                int lc = ' ';
                for(char ch: map.keySet()){ // 取 map 中索引最小的字符, 从索引最小的字符开始 remove
                    if(map.get(ch) < li){
                        li = map.get(ch);
                        lc = ch;
                    }
                }
                map.remove(lc);
                start = li + 1; // 标记子串的 start 位置好计算 len
            }
            map.put(c, i);
            max = Math.max(max, i - start + 1);
        }
        return max;
    }

    public static int  LSD2(String s){

        int start = 0, max = 0;
        Map<Character, Integer> map = new HashMap<>(); // char - times
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.size() == 2 && !map.containsKey(c)){
                int li = s.length(); // last index
                char lc = ' '; // last char
                for(char ch: map.keySet()){ // find 最早的 index
                    int index = map.get(ch);
                    if(index < li){
                        li = index;
                        lc = ch;
                    }
                }
                map.remove(lc);
                start = li + 1; // move sliding window start
            }
            map.put(c, i);
            max = Math.max(max, i - start + 1);
        }
        return max;
    }


    public static void main(String[] args){
        System.out.println(LSD2("eceba"));
    }
}
