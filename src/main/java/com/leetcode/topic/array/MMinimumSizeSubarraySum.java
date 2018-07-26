package com.leetcode.topic.array;

import com.util.Question;

@Question(id = 209, title = "Minimum Size Subarray Sum", hint = "Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead")
public class MMinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int i = 0;
        int j = 0;
        int min = nums.length + 1;
        int sum = 0;
        while (j < nums.length) {
            sum += nums[j];
            // move the left pointer i to right until sum is smaller than s
            while (sum >= s) {
                min = Math.min(j - i + 1, min);
                sum -= nums[i];
                i ++;
            }
            j ++;
        }
        return min == nums.length + 1 ? 0 : min;
    }

}
