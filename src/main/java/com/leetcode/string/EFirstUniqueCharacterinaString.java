package com.topic.string;

import com.util.Best;
import com.util.Question;
import com.util.Self;

@Question(id = 387, title = "First Unique Character in a String", hint = "" +
        "1. Given a string, find the first non-repeating character in it and return it's index." +
        "2. If it doesn't exist, return -1")
public class EFirstUniqueCharacterinaString {

    @Best
    @Self(thought = "frequency[] + travel", complexity = "O(n)")
    public static int solution(String s) {
        int[] frequency = new int[26];
        for(int i = 0; i < s.length(); i ++)
            frequency[s.charAt(i) - 'a'] ++;
        for(int i = 0; i < s.length(); i ++)
            if(frequency[s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }

    public static void main(String[] args){
        System.out.print(solution("leetcode"));
    }
}
