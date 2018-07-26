package com.leetcode.topic.array;

import com.util.Best;
import com.util.Question;
import com.util.Self;

import java.util.Arrays;

@Question(id = 283, title = "Move Zeroes", hint = "" +
        "1. Move all the 0's to the end of array." +
        "2. All the non-zero elements must retain their original order.")
public class EMoveZeroes {

    @Best(thought = "use left to save non-zero element, and swap", complexity = "O(n)")
    static void leetcode(int[] nums){
        if (nums == null || nums.length == 0) {
            return;
        }

        for (int i = 0, left = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            nums[left] = nums[i];
            if (left != i) {
                nums[i] = 0;
            }
            left++;
        }
        return ;
    }


    @Self(thought = "miss")
    static void solution(int[] nums){

    }


    public static void main(String[] args){
        int[] nums = {1, 1, 0, 3, 12};
        leetcode(nums);
        System.out.println(Arrays.toString(nums));
    }
}
