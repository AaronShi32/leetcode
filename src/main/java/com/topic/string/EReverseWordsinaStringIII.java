package com.topic.string;

import com.util.Best;
import com.util.Question;
import com.util.Self;

@Question(id = 557, title = "Reverse Words in a String III", hint = "" +
        "1. Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.")
public class EReverseWordsinaStringIII {

    @Best
    @Self
    public static String solution(String s){
        if(s.length() == 0){
            return s;
        }
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String word : words){
            sb.append(reverse(word) + " ");
        }
        return sb.substring(0, sb.length() - 1);
    }

    private static String reverse(String s){
        int len = s.length();
        StringBuilder ns = new StringBuilder();
        for(int i = len - 1; i >= 0; i--){
            ns.append(s.charAt(i));
        }
        return ns.toString();
    }


    public static void main(String[] args){
        System.out.print(solution("Let's take LeetCode contest"));
    }
}
