package com.topic.interview;

import com.util.Best;
import com.util.Question;
import com.util.Self;
import java.util.HashMap;

@Question(id = 560, title = "Subarray Sum Equals K", hint = "" +
        "1. find the total number of continuous subarrays whose sum equals to k")
public class InterMSubarraySumEqualsK {

    @Best
    @Self(thought = "hashmap", complexity = "O(n)")
    static int solution(int[] nums, int k){
        int count = 0, sum = 0;
        HashMap< Integer, Integer > map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) // sum - k = 之前计算过的 sum
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;

    }


    public static void main(String[] args){
        int h;
        System.out.println((h = 20) ^ (h >>> 16));
    }

}
