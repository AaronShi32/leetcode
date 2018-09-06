package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MLetterCombinationsofaPhoneNumber {

    public List<String> letterCombinations(String s) {
        List<String> ans = new ArrayList<>();
        List<List<String>> digits = init();
        backtracking(digits, s,0, "", ans);
        return ans;

    }

    private void backtracking(List<List<String>> digits, String s, int start, String result, List<String> ans){
        if(result.length() == s.length()){
            ans.add(result);
            return;
        }
        for(int i = start; i < s.length(); i++){
            Integer idx = Integer.parseInt(s.charAt(i) + "");
            List<String> letters = digits.get(idx - 2);
            for(int j = 0; j < letters.size(); j ++){
                result += letters.get(j);
                backtracking(digits, s, i + 1, result, ans);
                result = result.substring(0, result.length() - 1);
            }
        }
    }

    private List<List<String>> init(){
        List<List<String>> digits = new ArrayList<>();
        digits.add(Arrays.asList("a", "b", "c"));
        digits.add(Arrays.asList("d", "e", "f"));
        digits.add(Arrays.asList("g", "h", "i"));
        digits.add(Arrays.asList("j", "k", "l"));
        digits.add(Arrays.asList("m", "n", "o"));
        digits.add(Arrays.asList("p", "q", "r", "s"));
        digits.add(Arrays.asList("t", "u", "v"));
        digits.add(Arrays.asList("w", "x", "y", "z"));
        return digits;
    }


    public static void main(String[] args){
        MLetterCombinationsofaPhoneNumber m = new MLetterCombinationsofaPhoneNumber();
        System.out.println(m.letterCombinations("23"));
    }
}
