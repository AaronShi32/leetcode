package com.topic.array;

import com.util.Question;
import com.util.Self;

@Question(id = 665, title = "Non-decreasing Array", hint = "" +
        "check if it could become non-decreasing by modifying at most 1 element")
public class ENondecreasingArray {

    @Self(thought = "miss")
    static boolean checkPossibility(int[] nums) {
        boolean first = true;
        for(int i = 0; i < nums.length - 1; i ++){
            if(nums[i] <= nums[i+1]){
                continue;
            }
            else if(first){
                first = false;
            }else{
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args){
        int[] nums = {4,2,1};
        System.out.println(checkPossibility(nums));
    }


}
