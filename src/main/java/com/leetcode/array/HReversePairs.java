package com.leetcode.array;

import java.util.Arrays;

public class HReversePairs {

    // T(i, j) = T(i, m) + T(m + 1, j) + C

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right)
            return 0;
        int mid = left + (right - left) / 2;
        int res = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
        for (int i = left, j = mid + 1; i <= mid; i++) {
            while (j <= right && nums[i] / 2.0 > nums[j]) // 对每个 i 统计 从 mid + 1 开始满足 nums[i] > nums[j] * 2
                j++;
            res += j - (mid + 1);
        }
        Arrays.sort(nums, left, right + 1);
        return res;
    }

    public static void main(String[] args){

    }
}
