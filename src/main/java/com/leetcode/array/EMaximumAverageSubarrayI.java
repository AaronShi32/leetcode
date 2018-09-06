package com.leetcode.array;

import com.util.Best;
import com.util.Question;
import com.util.Self;

import java.util.Arrays;

@Question(id = 643, title = "Maximum Average Subarray I", hint = "find the contiguous subarray of given length k that has the maximum average value")
public class EMaximumAverageSubarrayI {

    @Best()
    @Self(thought = "Sum of Sliding window", complexity = "O(n)")
    static double solution(int[] nums, int k){
        int len = nums.length, sum = 0, max = 0;

        for(int i = 0; i < k; i++){
            sum += nums[i];
        }

        // init sliding value
        max = sum;

        for(int i = k; i < len; i++){
            sum += nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }
        return max / 1.0 / k;
    }


    public static void main(String[] args){
        int[] nums = {-1};
        int k = 1;
        System.out.println(solution(nums, k));
    }
}
