package com.leetcode.topic.array;

import com.util.Question;
import com.util.Self;

@Question(id = 35, title = "Search Insert Position", hint = "Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order")
public class ESearchInsertPosition {

    @Self(thought = "miss")
    public static int solution(int[] nums, int target) {
        for (int i=0; i < nums.length; i++){
            if (target == nums[i] || target < nums[i]){
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args){
        int[] nums = {1,3,5,6};
        System.out.println(solution(nums, 7));
    }

}
