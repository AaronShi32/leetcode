package com.topic.array;

import com.util.Best;
import com.util.Question;
import com.util.Self;

@Question(id = 23, title = "Remove Element", hint = "" +
        "1. Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory" +
        "2. The order of elements can be changed")
public class ERemoveElement {

    @Best
    @Self(complexity = "O(n)")
    static int solution(int[] nums, int val){
        int len = nums.length;
        int m = 0;
        for(int i = 0; i < len; i++){
            if(nums[i] != val){
                nums[m++] = nums[i];
            }
        }
        return m;
    }


    public static void main(String[] args){

    }
}
