package com.leetcode.array;

import com.util.Self;

public class MSearchinRotatedSortedArray {

    @Self(thought = "binary search", complexity = "")
    static int solution(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int lo = 0, hi = nums.length - 1, mid = -1;
        while (lo <= hi) {

            mid = lo + (hi - lo) / 2;

            if (target == nums[mid]) return mid;

            if (nums[mid] >= nums[hi]) { // 说明左边是有序的 nums[lo...mid]
                if (target < nums[mid] && target >= nums[lo]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else { // 说明右边是有序的 nums[mid...hi]
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }


    static int pratice(int[] nums, int target) {
        return 0;
    }


    public static void main(String[] args) {
        int h;
        System.out.println((h = 20) ^ (h >>> 16));

    }
}
