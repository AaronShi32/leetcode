package com.leetcode.string;

import com.util.Idea;

import java.util.Stack;

@Idea(use = "stack + spilt(\"\\s\")")
public class MReverseWordsinaString {

    public String reverseWords(String s) {

        if(s == null){
            return s;
        }

        s = s.trim();

        String[] words = s.trim().split("\\s+");
        Stack<String> stack = new Stack<String>();
        for(String word: words){
            stack.push(word);
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.empty()){
            sb.append(stack.pop() + " ");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

}
