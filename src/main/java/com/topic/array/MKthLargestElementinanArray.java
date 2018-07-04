package com.topic.array;

import com.util.Question;

@Question(id = 215, hint = "Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.")
public class MKthLargestElementinanArray {

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            int pos = quickSelect(nums, left, right);
            if (pos + 1 == k) {
                return nums[pos];
            }
            else if (pos + 1 > k) {
                right = pos - 1;
            }
            else {
                left = pos + 1;
            }
        }
    }

    private int quickSelect(int[] nums, int l, int r) {
        int left = l, right = r;
        int pivot = left;
        while (left < right) {
            while (left < right && nums[left] >= nums[pivot]) {
                left++;
            }
            while (left < right && nums[right] < nums[pivot]) {
                right--;
            }
            // swap
            if (left < right) {
                swap(nums, left, right);
                left++;
                right--;
            }

        }
        if (nums[left] < nums[pivot]) {
            swap(nums, pivot, left - 1);
            return left - 1;
        }
        else {
            swap(nums, pivot, left);
            return left;
        }

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
