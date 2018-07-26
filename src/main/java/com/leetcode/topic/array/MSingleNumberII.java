package com.leetcode.topic.array;

import com.util.Question;
import com.util.Self;

import java.util.Arrays;

@Question(id = 137, hint = "Given a non-empty array of integers, " +
        "every element appears three times except for one, " +
        "which appears exactly once. Find that single one.")
public class MSingleNumberII {

    @Self(thought = "排序遍历")
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length < 4){
            return nums[0];
        }
        int len = nums.length;
        Arrays.sort(nums);
        if(nums[1] != nums[0]) return nums[0];
        for(int i = 1; i < len; i++){
            if(nums[i] != nums[i-1])
                if(i == len - 1)
                    return nums[i];
                else if(i % 3 != 0)
                    return nums[i-1];
        }
        return -1;

    }


    public static void main(String[] args){

    }

}
