package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class MGenerateParentheses {

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if(n == 0){
            return ans;
        }
        backtracking(0, 0, n, "", ans);
        return ans;
    }

    private static void backtracking(int open, int close, int max, String str, List<String> ans){

        if(str.length() == max * 2){
            ans.add(str);
            return;
        }
        if(open < max)
            backtracking(open + 1, close, max, str + "(", ans);
        if(close < open)
            backtracking(open, close + 1, max, str + ")", ans);

    }

    public static void main(String[] args){
        System.out.println(generateParenthesis(6));
    }
}
