package com.leetcode.topic.array;

import com.util.Question;

@Question(id = 153, hint = "Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.")
public class MFindMinimuminRotatedSortedArray {

    public int findMin(int[] nums) {

        if(nums == null || nums.length == 0){
            return 0;
        }

        if(nums.length == 1){
            return nums[0];
        }

        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            int mid = l + (r - l)/2;
            if(mid > 0 && nums[mid] < nums[mid - 1]){
                return nums[mid];
            }
            if(nums[l] <= nums[mid] && nums[mid] > nums[r]){
                l = l + 1;
            } else {
                r = r - 1;
            }

        }

        return nums[l];

    }
}
