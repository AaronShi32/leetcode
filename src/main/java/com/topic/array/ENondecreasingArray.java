package com.topic.array;

import com.util.Best;
import com.util.Question;
import com.util.Self;

@Question(id = 665, title = "Non-decreasing Array", hint = "" +
        "1. check if it could become non-decreasing by modifying at most 1 element")
public class ENondecreasingArray {

    @Best(thought = "change element to judge", complexity = "O(n)")
    static boolean leetcode(int[] nums){
        int n = nums.length, count = 0;

        for (int i = 0; i + 1 < n; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
                if (i > 0 && nums[i + 1] < nums[i - 1]) nums[i + 1] = nums[i];
                else nums[i] = nums[i + 1];
            }
        }

        return count <= 1;
    }


    @Self(thought = "miss")
    static boolean checkPossibility(int[] nums) {
//        boolean first = true;
//        for(int i = 0; i < nums.length - 1; i ++){
//            if(nums[i] <= nums[i+1]){
//                continue;
//            }
//            else if(first){
//                first = false;
//            }else{
//                return false;
//            }
//        }
//        return true;
        return false;
    }


    public static void main(String[] args){
        int[] nums = {4,2,1};
        System.out.println(checkPossibility(nums));
    }


}
