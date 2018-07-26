package com.leetcode.topic.array;

import com.util.Best;
import com.util.Question;
import com.util.Self;

import java.util.Arrays;

@Question(id = 167, title = "Two Sum II", hint = "assume that each input would have exactly one solution and you may not use the same element twice")
public class ETwoSumII {

    @Best(thought = "binary search", complexity = "O(nlogn)")
    static int[] leetcode(int[] nums, int target){

        for(int i = 0; i < nums.length; i++){
            int left = i + 1, right = nums.length - 1, gap = target - nums[i];
            while(left <= right){
                int m = left + (right - left) / 2;
                if(nums[m] == gap) {
                    return new int[]{i + 1, m + 1};
                }
                if(nums[m] > gap){
                    right = m - 1;
                }else{
                    left = m + 1;
                }
            }
        }

        return null;

    }


    @Self(thought = "two pointers + traversal", complexity = "O(n)")
    static int[] solution(int[] nums, int target){

        int left = 0, right = nums.length - 1;
        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum == target){
                return new int[]{left + 1, right + 1};
            }else if(sum < target){
                left ++;
            }else{
                right --;
            }
        }
        return null;
    }

    public static void main(String[] args){

        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(solution(nums, 9)));
    }

}
