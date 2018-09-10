package com.leetcode.prime;

import java.util.Arrays;

public class MReverseWordsinaStringII {

    public static String[] reverseWords(String[] words) {
        if (words == null || words.length == 1) {
            return words;
        }
        int start = 0, end = words.length - 1;
        reverse(words, start, end);
        int gap = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i] == " ") {
                reverse(words, gap, i - 1);
                gap = i + 1;
            }
        }
        reverse(words, gap, words.length - 1); // don't forget reverse last word outside loop
        return words;
    }

    private static void reverse(String[] words, int start, int end) {
        while (start < end) {
            String tmp = words[start];
            words[start] = words[end];
            words[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        String[] words = {"t", "h", "e", " ", "s", "k", "y", " ", "i", "s", " ", "b", "l", "u", "e"};
        System.out.println(Arrays.toString(reverseWords(words)));
    }


}
