package com.topic.array;

import com.util.Best;
import com.util.Question;
import com.util.Self;

@Question(id = 53, title = "Maximum Subarray", hint = "Find the contiguous subarray within an array (containing at least one number) which has the largest sum")
public class EMaximumSubarray {

    @Best(thought = "dp", complexity = "O(n)")
    static int leetcode(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = nums[0];
        int max = dp[0];

        for(int i = 1; i < n; i++){
            // 如果之前的和小于0, 那么无需累加, 直接从0开始加就好
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }

        return max;
    }


    @Best(thought = "double record one traversal", complexity = "O(n)")
    static int solution(int[] nums) {
        int maxSoFar = nums[0], maxEndingHere = nums[0], len = nums.length;
        for (int i = 1; i < len; ++i){
            // if current plus next < next, we need begin from next
            maxEndingHere= Math.max(maxEndingHere + nums[i], nums[i]);
            maxSoFar=Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    @Self(thought = "miss")
    static void solution2(){}



    public static void main(String[] args){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(leetcode(nums));
    }

}
