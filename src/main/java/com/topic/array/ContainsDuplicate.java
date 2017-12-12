package com.topic.array;

import com.util.Best;
import com.util.Question;
import com.util.Self;

import java.util.HashSet;
import java.util.Set;

@Question(id = 217, title = "Contains Duplicate", hint = "return true if any value appears at least twice, else false")
public class ContainsDuplicate {

    @Best
    @Self(thought = "Set dereplication", complexity = "O(n)")
    static boolean solution(int[] nums){
        Set<Integer> distinct = new HashSet<Integer>();
        int len = nums.length;
        for(int i = 0; i < len; i++){
           if(!distinct.add(nums[i])){
               return true;
           }
        }
        return false;
    }


    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,4};
        System.out.println(solution(nums));
    }
}
