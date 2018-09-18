package com.leetcode.backtracking;

import java.util.Arrays;
import java.util.List;

public class MWorkBreak {

    private static boolean found = false;

    public static boolean wordBreak(String s, List<String> wordDict) {
        backtracking(s, wordDict);
        return found;
    }


    private static void backtracking(String s, List<String> wordDict){
        if(s.length() == 0){
            found = true;
            return;
        }
        for(int i = 0; i < wordDict.size(); i++){
            String word = wordDict.get(i);
            if(s.startsWith(word)){
                backtracking(s.substring(word.length(), s.length()), wordDict);
            }
        }
    }

    // dp[i] means subString(0, i) can be break use dicts
    private static boolean dp(String s, List<String> dicts){
        if(s == null || s.length() == 0){
            return true;
        }

        int n = s.length();

        boolean[] dp = new boolean[n];

        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j <= i; j++){
                String sub = s.substring(j, i + 1);
                if(dicts.contains(sub) && (j == 0 || dp[j - 1])){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n - 1];
    }


    public static void main(String[] args){
        String[] words = {"leet", "code"};
        List<String> dicts = Arrays.asList(words);
        System.out.println(wordBreak("leetcode", dicts));
        System.out.println(dp("leetcode", dicts));
    }

}
