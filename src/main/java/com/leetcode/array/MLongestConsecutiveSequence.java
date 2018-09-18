package com.leetcode.array;

public class MLongestConsecutiveSequence {

    private static int max = 0, index = 0;

    public static String solution(String s){
        if(s == null || s.length() < 2){
            return s;
        }
        int n = s.length();
        for(int i = 0; i < n - 1; i++){
            isPalidrom(s, i, i);
            isPalidrom(s, i, i + 1);
        }
        return s.substring(index, index + max);
    }

    private static void isPalidrom(String s, int i, int j){
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        if(max < j - i - 1){
            max = j - i - 1;
            index = i + 1;
        }
    }

    public static void main(String[] args){
        System.out.println(solution("cbbca"));
        System.out.println(solution("cbba"));

    }

}
