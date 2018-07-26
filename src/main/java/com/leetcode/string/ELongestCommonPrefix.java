package com.topic.string;

import com.util.Best;
import com.util.Self;

import java.util.HashMap;
import java.util.Map;

public class ELongestCommonPrefix {

    private static String[] tc = {"zflower","zflow","zflight"};

    @Best
    @Self(thought = "miss")
    public static String solution(String[] strs){
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    public static void main(String[] args){
        System.out.println(solution(tc));
        String c = "car";
        String b = "y";
        System.out.println(c.indexOf(b));
    }
}
