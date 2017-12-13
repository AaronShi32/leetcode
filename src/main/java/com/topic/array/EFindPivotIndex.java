package com.topic.array;

import com.util.Best;
import com.util.Question;
import com.util.Self;

@Question(id = 724, title = "Find Pivot Index", hint = "" +
        "pivot index define as Sum[0, pivot) = Sum(pivot, len-1).\n" +
        "If no such index exists, we should return -1. " +
        "If there are multiple pivot indexes, you should return the left-most pivot index")
public class EFindPivotIndex {

    @Best(thought = "double traversal", complexity = "O(n)")
    static int leetcode(int[] nums){
        int sum = 0;
        //Get the sum of the array
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            //if if sum - nums[i] == preSum * 2, mean left sum equals to right sum
            if (sum - nums[i] == preSum * 2) {
                return i;
            }
            preSum += nums[i];
        }
        //not found the index
        return -1;
    }

    @Self(thought = "miss")
    static int solution(int[] nums){
        return -1;
    }

    public static void main(String[] args){
        int[] nums = {-1,-1,-1,-1,-1,0};
        System.out.println(solution(nums));
    }

}
