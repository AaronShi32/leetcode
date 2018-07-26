package com.leetcode.topic.array;

import com.util.Best;
import com.util.Question;
import com.util.Self;

import java.util.Arrays;

@Question(id = 169, title = "Majority Element", hint = "" +
        "1. majority element is the element that appears more than ⌊ n/2 ⌋ times and always exist")
public class EMajorityElement {

    @Best(thought = "voting algorithm", complexity = "O(n)")
    public int leetcode(int[] nums) {
        int count = 0, ret = 0;
        for (int num: nums) {
            if (count == 0)
                ret = num;
            if (num != ret)
                count--;
            else
                count++;
        }
        return ret;
    }


    @Self(thought = "sort and get mid", complexity = "O(logn)")
    static int solution(int[] nums){
        int len = nums.length;
        Arrays.sort(nums);
        return nums[(len - 1) / 2];
    }


    public static void main(String[] args){
        int[] nums = {3,2,3,2,5,2,7,2,9,2};
        System.out.println(solution(nums));
    }
}
