package com.topic.game;

import com.util.Question;

@Question(id = 520, title = "Detect Capital", hint = "" +
        "1.All letters in this word are capitals, like \"USA\"." +
        "2.All letters in this word are not capitals, like \"leetcode\"" +
        "3.Only the first letter in this word is capital if it has more than one letter, like \"Google\".")
public class EDetectCapital {

    public boolean detectCapitalUse(String word) {
        if(Character.isLowerCase(word.charAt(0))){
            return word.equals(word.toLowerCase());
        }else{
            return word.equals(word.toUpperCase()) || word.substring(1).equals(word.substring(1).toLowerCase());
        }
    }
}
