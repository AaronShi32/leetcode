package com.topic.array;

import com.util.Self;

import java.util.*;

public class MTopKFrequentElements {


    @Self(thought = "hashmap + bucket", complexity = "")
    static List<Integer> solution(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        for(int n: map.keySet()){
            int freq = map.get(n);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(n);
        }

        List<Integer> ret = new LinkedList<>();
        for(int i = bucket.length - 1; i > 0 && k > 0; i--){
            if(bucket[i] != null){
                ret.addAll(bucket[i]);
                k -= bucket[i].size();
            }
        }

        return ret;
    }


    public static void main(String[] args){
        int h;
        System.out.println((h = 20) ^ (h >>> 16));
    }

}
