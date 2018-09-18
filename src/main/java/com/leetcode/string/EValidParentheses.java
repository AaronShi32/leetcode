package com.leetcode.string;

import com.util.Best;
import com.util.Question;
import com.util.Self;

import java.util.Stack;

@Question(id = 20, title = "Valid Parentheses")
public class EValidParentheses {

    @Best
    @Self(thought = "stack", complexity = "O(n)")
    public static boolean solution(String s){
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args){
        System.out.print(solution("(){}[]((()]))"));
    }
}
