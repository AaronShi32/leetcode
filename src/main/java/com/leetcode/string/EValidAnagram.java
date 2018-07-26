package com.topic.string;

import com.util.Question;
import com.util.Self;

@Question(id = 242, title = "Valid Anagram", hint = "" +
        "1. write a function to determine if t is an anagram of s" +
        "2. t 中的 char 是否都在 s 中")
public class EValidAnagram {

    @Self(thought = "字母表")
    public static boolean solution(String s, String t){
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }



}
