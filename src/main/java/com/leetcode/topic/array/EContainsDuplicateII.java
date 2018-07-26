package com.leetcode.topic.array;

import com.util.Best;
import com.util.Question;
import com.util.Self;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


@Question(id = 291, title = "Contains Duplicate II", hint = "" +
        "1. two distinct indices i and j : 1.nums[i] = nums[j], 2. |i - j| <= k")
public class EContainsDuplicateII {

    @Best(thought = "Set remove when i > k", complexity = "O(n)")
    public boolean leetcode(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]); // remove (i-k-1) when i > k
            if(!set.add(nums[i])) return true; // repeat
        }
        return false;
    }


    @Self(thought = "Map<value, index>", complexity = "O(n)")
    static boolean solution(int[] nums, int k){
        Map<Integer, Integer> m = new HashMap<>();
        int len = nums.length;
        for(int i = 0; i < len; i++){
            if(m.containsKey(nums[i])){
                if(Math.abs(m.get(nums[i]) - i) <= k){
                    return true;
                }
            }
            m.put(nums[i], i);
        }
        return false;
    }


    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,3,7,8};
        System.out.println(solution(nums, 3));
    }
}
