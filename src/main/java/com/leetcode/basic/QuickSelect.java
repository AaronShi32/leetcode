package com.leetcode.basic;

import java.util.Arrays;

/**
 * 模板
 *
 * partition 是升序排序, 所以 Kth largest : nums.length - k
 *                           Kth smaller : k - 1
 */
public class QuickSelect {

    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        return partition(nums, 0, nums.length - 1, nums.length - k);
    }

    public static int findKthSmallest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        return partition(nums, 0, nums.length - 1, k - 1);
    }

    private static int partition (int[] nums, int start, int end, int k) {
        if (start >= end) return nums[k];
        int left = start;
        int right = end;
        int pivot = nums[(start + end) / 2]; // 二分
        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap (nums, left ++, right--);
            }
        }
        if (k <= right) {
            partition(nums, start, right, k);
        }
        if (k >= left) {
            partition(nums, left, end, k);
        }
        return nums[k];
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {23, 5, 1, 52, 3, 46, 88, 12, 0};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int[] data = {23, 5, 1, 52, 3, 46, 88, 12, 0};
        System.out.println(findKthLargest(data, 5));
        System.out.println(findKthSmallest(data, 4));
    }

}
