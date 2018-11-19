package com.leetcode.string;

import com.util.Best;
import com.util.Self;

import java.util.Arrays;
import java.util.Comparator;

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


    public static String  solution2(String[] strs){
        if(strs == null || strs.length < 2){
            return "";
        }
        Arrays.sort(strs, Comparator.comparingInt(s -> s.length()));
        String shortWord = strs[0], targetWord = strs[strs.length - 1];
        String prefix = "";
        for(int i = 0; i < shortWord.length(); i++){
            if(shortWord.charAt(i) != targetWord.charAt(i)){
                break;
            }
            prefix += shortWord.charAt(i) + "";
        }
        return prefix;
    }


    public static void main(String[] args){
        System.out.println(solution2(tc));
    }
}
