package com.leetcode.array;

import com.util.Question;

@Question(id = 153, hint = "Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.")
public class MFindMinimuminRotatedSortedArray {

    public int findMin(int[] nums) {

        if (nums == null || nums.length == 0) return 0;
        int lo = 0, hi = nums.length - 1, mid = -1;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1]) { // 旋转的点 pivot
                return nums[mid];
            }
            if (nums[lo] <= nums[mid] && nums[mid] > nums[hi]) { // 处于mid升序队列 那么最小的只能在右边 lo = mid + 1
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return nums[lo];

    }
}
