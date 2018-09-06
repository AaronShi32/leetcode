package com.leetcode.array;

import com.util.Best;
import com.util.Question;
import com.util.Self;

@Question(id = 152, title = "Maximum Product Subarray")
public class MMaximumProductSubarray {

    @Best(thought = "dp", complexity = "O(n)")
    @Self(thought = "miss")
    public int solution(int[] nums) {
        int len = nums.length;
        int r = nums[0], min = r, max = r;
        for(int i = 1; i < len; i++){
            if(nums[i] < 0){
                int tmp = min;
                min = max;
                max = tmp;
            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);
            r = Math.max(r, max);
        }
        return r;
    }

    public static void main(String[] args){
        
    }

}
