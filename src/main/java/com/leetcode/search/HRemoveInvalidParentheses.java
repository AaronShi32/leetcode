package com.leetcode.search;

import java.util.*;

public class HRemoveInvalidParentheses {

    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();

        Set<String> visited = new HashSet<>();
        visited.add(s);

        Queue<String> q = new LinkedList<>();
        q.offer(s);

        boolean found = false;

        while (!q.isEmpty()) {
            String str = q.poll();

            if (isValid(str)) {
                ans.add(str);
                found = true;
            }

            if (found) continue; // 停止在这一轮, 遍历清空当前队列

            for (int j = 0; j < str.length(); j++) {
                if (Character.isAlphabetic(str.charAt(j))) {
                    continue;
                }
                String sub = str.substring(0, j) + str.substring(j + 1);
                if(visited.add(sub)) {
                    q.offer(sub);
                }
            }
        }

        return ans;
    }


    private boolean isValid(String str) {
        Stack<Character> s = new Stack<>();
        for (char c : str.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                continue;
            } else if (c == '(') {
                s.push(')');
            } else if (s.isEmpty() || s.pop() != c) {
                return false;
            }
        }
        return s.isEmpty();
    }

    public static void main(String[] args) {
        HRemoveInvalidParentheses c = new HRemoveInvalidParentheses();
        System.out.println(c.removeInvalidParentheses("n"));
    }

}
