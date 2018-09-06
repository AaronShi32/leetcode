package com.leetcode.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MAddandSearchWord {

    private Map<Integer, List<String>> map;

    /** Initialize your data structure here. */
    public MAddandSearchWord() {
        map = new HashMap<Integer, List<String>>();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        int len = word.length();
        if(map.containsKey(len)){
            List<String> words = map.get(len);
            words.add(word);
        }else{
            List<String> words = new ArrayList<>();
            words.add(word);
            map.put(len, words);
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        int len = word.length();
        if(!map.containsKey(len)){
            return false;
        }
        List<String> words = map.get(len);
        for(String s: words){
            if(isSame(s, word)){
                return true;
            }
        }
        return false;
    }

    private boolean isSame(String a, String b){
        int len = a.length();
        for(int i = 0; i < len; i++){
            if(b.charAt(i) != '.' && a.charAt(i) != b.charAt(i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){

        //["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
        //[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
        MAddandSearchWord c = new MAddandSearchWord();
        c.addWord("bad");
        c.addWord("dad");
        c.addWord("mad");
        c.addWord("pad");
        c.search("bad");
        c.search(".ad");
        c.search("b..");

    }

}
