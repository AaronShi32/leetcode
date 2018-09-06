package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class MPalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        backtracking(s, new ArrayList<String>(), ans);
        return ans;

    }

    private void backtracking(String s, List<String> result, List<List<String>> ans){
        if(s.length() == 0){
            ans.add(new ArrayList<String>(result));
            return;
        }
        for(int i = 0; i < s.length(); i++){
            String sub = s.substring(0, i + 1);
            if(isPalindrome(sub)){
                result.add(sub);
                backtracking(s.substring(i + 1), result, ans);
                result.remove(result.size() - 1);
            }
        }

    }

    private boolean isPalindrome(String s){
        for(int i = 0, j = s.length() - 1; i < j; i++, j--){
            if(s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        MPalindromePartitioning c = new MPalindromePartitioning();
        System.out.println(c.partition("aab"));
    }
}
