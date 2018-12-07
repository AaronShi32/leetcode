package com.leetcode.array;

import com.util.Self;

public class MSearchinRotatedSortedArray {

    @Self(thought = "binary search", complexity = "")
    static int solution(int[] nums, int target){
        if (nums == null || nums.length == 0) return -1;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] >= nums[l]) {
                if (target <= nums[m] && target >= nums[l]) r = m;
                else l = m + 1;
            } else {
                if (target > nums[m] && target <= nums[r]) l = m + 1;
                else r = m;
            }
        }
        return nums[l] == target ? l : -1;
    }


    static int pratice(int[] nums, int target){
        return 0;
    }


    public static void main(String[] args){
        int h;
        System.out.println((h = 20) ^ (h >>> 16));

    }
}
