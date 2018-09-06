package com.leetcode.array;

import com.util.Question;

import java.util.HashMap;
import java.util.Map;

@Question(id = 260, hint = "Given an array of numbers nums, " +
        "in which exactly two elements appear only once and all the other elements appear exactly twice." +
        " Find the two elements that appear only once.")
public class MSingleNumberIII {

    public int[] singleNumber(int[] nums) {

        int[] result = new int[2];
        int c = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for(int key: map.keySet()){
            if(map.get(key) == 1){
                result[c++] = key;
            }
        }

        return result;

    }
}
