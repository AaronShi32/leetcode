package com.leetcode.string;

import com.util.Best;
import com.util.Question;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Question(id = 3, title = "Longest Substring Without Repeating Characters", hint = "" +
        "1. Given \"abcabcbb\", the answer is \"abc\", which the length is 3." +
        "2. Given \"bbbbb\", the answer is \"b\", with the length of 1." +
        "3. Given \"pwwkew\", the answer is \"wke\", with the length of 3. " +
        "Note that the answer must be a substring, \"pwke\" is a subsequence and not a substring.")
public class MLongestSubstringWithoutRepeatingCharacters {

    @Best(thought = "hashset", complexity = "O(n)")
    public static int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }

    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("aab"));
        Map<Integer, Integer> map = new ConcurrentHashMap<>();
    }
}
