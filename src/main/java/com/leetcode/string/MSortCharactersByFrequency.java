package com.topic.string;

import com.util.Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Question(id = 451, title = "Sort Characters By Frequency", hint = "" +
        "1. Given a string, sort it in decreasing order based on the frequency of characters")
public class MSortCharactersByFrequency {



    public static String solution(String text){

        // calculate char - times
        Map<Character, Integer> map = new HashMap<>();
        for(char c :  text.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        // use bucket sort
        List<Character>[] bucket = new List[text.length() + 1];
        for(char key : map.keySet()){
            int frequency = map.get(key);
            if(bucket[frequency] == null){
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        StringBuilder sb = new StringBuilder();

        // decreasing order use bucket(array)
        for(int pos = bucket.length - 1; pos >= 0; pos-- ){
            if(bucket[pos] != null){
                for(char c: bucket[pos]){
                    for(int i = 0; i < map.get(c); i++){
                        sb.append(c);
                    }
                }
            }
        }

        return sb.toString();

    }


    public static void main(String[] args){
        System.out.print(solution("treeeesttts"));
    }

}
