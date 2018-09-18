package com.leetcode.backtracking;

import java.util.*;

/*
 * find all shortest transformation sequence(s)
 * */

public class WordLadderII {

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return ans;
        }
        List<String> init = new ArrayList<>();
        init.add(beginWord);
        backtracking(wordList, beginWord, endWord, init, ans);
        if(ans.isEmpty()){
            return ans;
        }
        Collections.sort(ans, Comparator.comparingInt(i -> i.size()));
        int min = ans.get(0).size();
        for(int i = 1; i < ans.size(); i++){
            if(ans.get(i).size() != min){
                return ans.subList(0, i);
            }
        }
        return ans;
    }

    private static void backtracking(List<String> wordList, String beginWord, String endWord, List<String> result, List<List<String>> ans) {
        if (beginWord.equals(endWord)) {
            ans.add(new ArrayList<>(result));
            return;
        }
        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            if (diff(beginWord, word) && !result.contains(word)) {
                result.add(word);
                backtracking(wordList, word, endWord, result, ans);
                result.remove(result.size() - 1);
            }
        }
    }

    private static boolean diff(String w1, String w2) {
        int dif = 0;
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                dif++;
            }
        }
        return dif == 1;
    }

    public static void main(String[] args) {
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> dicts = Arrays.asList(words);
        System.out.println(findLadders("hit", "cog", dicts));
    }
}
