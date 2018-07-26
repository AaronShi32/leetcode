package com.topic.interview;

import com.util.Best;
import com.util.Question;
import com.util.Self;

import java.util.ArrayList;
import java.util.List;

@Question(id = 448, title = "Find All Numbers Disappeared in an Array", hint = "" +
        "1. some elements appear twice and others appear once" +
        "2. Find all the elements of [1, n] inclusive that do not appear in this array." +
        "3. do it without extra space and in O(n) runtime")
public class EFindAllNumbersDisappearedinanArray {

    @Best
    @Self(thought = "two travel and reset -", complexity = "O(n)")
    static List<Integer> solution(int[] nums){
        List<Integer> ret = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }
        for(int i = 0; i < n; i++){
            if(nums[i] > 0) {
                ret.add(i + 1);
            }
        }

        return ret;
    }


    public static void main(String[] args){
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(solution(nums));
    }
}
