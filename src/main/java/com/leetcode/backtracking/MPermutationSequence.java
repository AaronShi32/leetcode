package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class MPermutationSequence {

    public static List<String> getPermutation(int n, int k) {
        List<String> ans = new ArrayList<>();
        backtracking(n, k, 1, "", ans);
        return ans;
    }

    private static void backtracking(int n, int k, int start, String result, List<String> ans){
        if(result.length() == n){
            ans.add(new String(result));
            return;
        }
        for(int i = start; i <= n; i++){
            String c = String.valueOf(i);
            if(result.indexOf(c) != -1) continue;
            result += c;
            backtracking(n, k, i + 1, result, ans);
            result = result.substring(0, result.length() - 1);
        }
    }

    public static void main(String[] args){
        System.out.println(getPermutation(3, 3));
    }

}
