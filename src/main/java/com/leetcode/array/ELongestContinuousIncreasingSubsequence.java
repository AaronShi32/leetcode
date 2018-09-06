package com.leetcode.array;

import com.util.Question;

@Question(id = 674)
public class ELongestContinuousIncreasingSubsequence {

    public static int findLengthOfLCIS(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        int max = 0;
        int local = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > 0) {
                local++;
            } else {
                max = Math.max(max, local);
                local = 1;
            }
        }

        return Math.max(local, max); // 持续递增
    }


    public static void main(String[] args) {

        int[] a = {1, 3, 5, 7, 9};

        System.out.println(findLengthOfLCIS(a));
    }

}
