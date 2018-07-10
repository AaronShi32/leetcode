package com.topic.interview;

import com.util.Question;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 腾讯: 2018.07.09 9:00 pm.
 */
@Question(id = 819, title = "Most Common Word", hint = "split(\"[ !?',;.]+\");")
public class EMostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {

        if(paragraph == null || paragraph == ""){
            return "";
        }

        String[] words = paragraph.toLowerCase().split("[ !?',;.]+");

        Map<String, Integer> bucket = new HashMap<String, Integer>();

        List<String> bannedList = Arrays.asList(banned);

        for(String word : words){
            if(!bannedList.contains(word)){
                bucket.put(word, bucket.getOrDefault(word, 0) + 1);
            }
        }

        String res = null;

        for(String word : bucket.keySet())
            if(res == null || bucket.get(word) > bucket.get(res)) // 精华
                res = word;
        return res;

    }
}
