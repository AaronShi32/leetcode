package com.leetcode.array;

import com.util.Best;
import com.util.Question;
import com.util.Self;

import java.util.Arrays;

@Question(id = 189, title = "Rotate Array", hint = "" +
        "1. right to K")
public class ERotateArray {

    @Best(thought = "reverse all, divide into reverse")
    @Self(thought = "miss")
    public static void solution(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end){
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args){
        int[] nums = {1,3,4,5,6,7,8,10};
        solution(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
