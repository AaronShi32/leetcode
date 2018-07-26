package com.leetcode.topic.array;

import com.util.Best;
import com.util.Question;
import com.util.Self;

@Question(id= 287, title = "Find the Duplicate Number")
public class MFindtheDuplicateNumber {

    @Best(thought = "", complexity = "")
    static void leetcode(){

    }

    @Self(thought = "", complexity = "")
    static int solution(int[] nums){
        int low = 1, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int cnt = 0;
            for (int a : nums) {
                if (a <= mid) ++cnt;
            }
            if (cnt <= mid) low = mid + 1;
            else high = mid;
        }
        return low;
    }


    public static void main(String[] args){
        int[] nums = {2,2,2,2,2};
        System.out.println(solution(nums));
    }

}
