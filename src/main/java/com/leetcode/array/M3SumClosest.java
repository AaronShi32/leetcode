package com.leetcode.array;

import com.util.Best;
import com.util.Question;
import com.util.Self;

import java.util.Arrays;

@Question(id = 16, title = "3Sum Closest", hint = "" +
        "1. find three integers in S such that the sum is closest to a given number, target" +
        "2. assume that each input would have exactly one solution")
public class M3SumClosest {

    @Best
    @Self(thought = "sort + binary search", complexity = "O(n2)")
    static int solution(int[] num, int target){
        int result = num[0] + num[1] + num[num.length - 1]; // random init
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int start = i + 1, end = num.length - 1; // binary search inner loop
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }


    public static void main(String[] args){
        int[] nums = {0, 0 ,0};
        int target = 1;
        System.out.println(solution(nums, target));
    }

}
