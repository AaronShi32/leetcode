package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class HPalindromePartitioning {

    private int min = Integer.MAX_VALUE;

    public int minCut(String s) {
        backtracking(s, new ArrayList<String>());
        return min;
    }

    private void backtracking(String s, List<String> result){
        if(0 == s.length()){
            min = Math.min(result.size(), min);
            return;
        }
        for(int i = 0; i < s.length(); i++){
            String sub = s.substring(0, i + 1);
            if(isPalindrome(sub)){
                result.add(sub);
                backtracking(s.substring(i + 1), result);
                result.remove(result.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s){
        for(int i = 0, j = s.length() - 1; i < j; i++, j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        HPalindromePartitioning c = new HPalindromePartitioning();
        c.minCut("aab");
    }
}
