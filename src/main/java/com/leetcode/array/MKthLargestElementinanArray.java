package com.leetcode.array;

import com.util.Question;

@Question(id = 215, hint = "Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.")
public class MKthLargestElementinanArray {

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start > end) return nums[k];
        int i = start, j = end;
        while (i <= j) {
            while (i <= j && nums[i] < nums[start]) i++; // 找到左边第一个大于 nums[start] 的元素
            while (i <= j && nums[j] > nums[start]) j--; // 找到右边第一个小于 nums[start] 的元素
            if (i <= j) swap(nums, i++, j--); //交换彼此到正确位置
        }
        // 跳出循环则说明 i > j 此时,
        // start ---- j
        //               nums[start]
        //                            i ---- end
        if (k <= j) quickSelect(nums, start, j, k); // start --- j
        if (k >= i) quickSelect(nums, i, end, k);   // i --- end
        return nums[k];
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
