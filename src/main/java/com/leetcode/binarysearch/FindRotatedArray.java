package com.leetcode.binarysearch;

public class FindRotatedArray {


    public static int findInRotatedArray(int[] nums, int target){
        int len = nums.length - 1;
        int r = partition(nums, 0, len, target);
        return r;
    }

    private static int partition(int[] nums, int start, int end, int target){
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] == target){
                return mid;
            }

            if(nums[mid] >= nums[start]){
                if(target >= nums[start] && target < nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            }

            if(nums[mid] <= nums[end]){
                if(target <= nums[end] && target > nums[mid])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int nums[] = {6,7,8,1,2,3,4,5,9};
        System.out.println(findInRotatedArray(nums, 2));

    }
}
