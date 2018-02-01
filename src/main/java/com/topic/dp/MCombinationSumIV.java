package com.topic.dp;

import com.util.Best;
import com.util.Question;
import com.util.Self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Question(id = 377, title = "Combination Sum IV", hint = "" +
        "1. Given an integer array with all positive numbers and no duplicates." +
        "2. find the number of possible combinations that add up to a positive integer target.")
public class MCombinationSumIV {

    @Self(thought = "TLE")
    public static int solution(int[] nums, int target){
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, target);
        return result.size();
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> record, int[] nums, int target) {
        if(target < 0){
            return;
        }
        if(target == 0){
            result.add(new ArrayList<>(record));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            record.add(nums[i]);
            backtrack(result, record, nums, target - nums[i]);
            record.remove(record.size() - 1);
        }
        return;
    }

    private static int[] dp;

    @Best(thought = "dp")
    public static int leetcode(int[] nums, int target) {
        dp = new int[target + 1];
        dp[0] = 1;
        Arrays.sort(nums);
        for (int goal = 1; goal <= target; goal++) {
            for (int a : nums) {
                if (goal < a) break;
                dp[goal] += dp[goal - a];
            }
        }
        return dp[target];
    }


    public static void main(String[] args){
        System.out.print(leetcode(new int[]{1,2,3}, 4));
    }
}
