package com.leetcode.array;

import java.util.Arrays;

/**
 * 摇摆排序
 */
public class MWiggleSort {

    /**
     * nums[0] <= nums[1] >= nums[2] <= nums[3]...
     *
     * @param nums
     */
    public static void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i + 1 < nums.length; i += 2) {
            int tmp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = tmp;
        }
    }

    /**
     * nums[0] < nums[1] > nums[2] < nums[3]...
     *
     * O(n) time and/or in-place with O(1) extra space
     *
     * @param nums
     */
    public static void wiggleSortII(int[] nums) {
        int[] temp = nums.clone();
        Arrays.sort(temp);
        int k = (nums.length + 1) / 2;
        int j = nums.length;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (i % 2 == 1) ? (temp[--j]) : (temp[--k]);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 5, 2, 1, 6, 4};
        wiggleSort(nums1);
        System.out.println(Arrays.toString(nums1));
        int[] nums2 = {1, 5, 1, 1, 6, 4};
        wiggleSortII(nums2);
        System.out.println(Arrays.toString(nums2));

    }
}
