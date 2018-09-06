package com.leetcode.string;

import com.util.Question;

@Question(id = 678)
public class MValidParenthesisString {

    public boolean checkValidString(String s) {
        int sum = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '*' || s.charAt(i) == '(') sum++;
            else sum--;
            if(sum < 0) return false;
        }
        if(sum  ==  0) return true;
        sum = 0;
        for(int i = s.length()-1; i >= 0; i--) {
            if(s.charAt(i) == '*' || s.charAt(i) == ')') sum++;
            else sum--;
            if(sum < 0) return false;
        }
        return true;
    }
}
