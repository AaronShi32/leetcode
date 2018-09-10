package com.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class MLongestSubstringwithAtLeastKRepeatingCharacters {

    public static int LDLK(String s, int k) {
        if(s == null || s.length() == 0){
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        char filter = '#';
        for(char c: map.keySet()){
            if(map.get(c) < k){
                filter = c;
            }
        }

        int max = 0;

        if(filter == '#'){
            return s.length();
        }else{
            String[] subs = s.split("" + filter);
            for(String sub: subs){
                max = Math.max(max, LDLK(sub, k));
            }
        }
        return max;
    }


    public static void main(String[] args){
        System.out.println(LDLK("aaabbcccddb", 3));
    }

}
