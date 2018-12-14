package com.leetcode.array;

public class MSearchinRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int lo = 0, hi = nums.length - 1, mid = -1;
        while (lo <= hi) {

            mid = lo + (hi - lo) / 2;

            if (target == nums[mid]) return true;

            if (nums[mid] > nums[hi]) { // 说明左边是有序的 nums[lo...mid]
                if (target < nums[mid] && target >= nums[lo]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else if (nums[mid] < nums[hi]) {
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else {
                hi--;
            }
        }
        return false;
    }

}
