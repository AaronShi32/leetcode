package com.leetcode.topic.array;

import com.util.Best;
import com.util.Question;
import com.util.Self;

import java.util.Arrays;


@Question(id = 561, title = "Array Partition I", hint = "array contains 2n integers")
public class EArrayPartitionI {

    @Best()
    @Self(thought = "sort + traversal")
    static int solution(int[] nums){
        Arrays.sort(nums);
        int len = nums.length;
        int sum = 0;
        for(int i = 0; i < len; i = i + 2){
            sum += Math.min(nums[i], nums[i+1]);
        }
        return sum;
    }

    public static void main(String[] args){
        int[] nums = {1,4,3,2};
        System.out.println(solution(nums));
    }

}
