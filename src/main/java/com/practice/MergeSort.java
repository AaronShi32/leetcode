package com.practice;

import java.util.Arrays;

public class MergeSort {

    //logN

    public static void sort(int[] nums, int start, int end, int[] temp) {
        if (start < end) {
            int mid = (end - start) / 2 + start;
            sort(nums, start, mid, temp);
            sort(nums, mid + 1, end, temp);
            merge(nums, start, mid, end, temp);
        }
    }

    public static void merge(int[] nums, int start, int mid, int end, int[] temp) {
        int i = start; //左序列指针
        int j = mid + 1; //右序列指针

        int t = 0;
        while (i <= mid && j <= end) {
            if (nums[i] < nums[j]) {
                temp[t++] = nums[i++];
            } else {
                temp[t++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[t++] = nums[i++];
        }
        while (j <= end) {
            temp[t++] = nums[j++];
        }

        t = 0;

        //将temp中的元素全部拷贝到原数组中
        while (start <= end) {
            nums[start++] = temp[t++]; //一定是从start开始填充, t归0
        }

    }


    public static void main(String[] args) {
        int[] array = {99, 5, 32, 6, 34, 6, 23, 76, 587, 354, 213, 62, 43, 64, 124, 124, 6, 47, 346, 234, 0};
        int[] temp = new int[array.length];
        sort(array, 0, array.length - 1, temp);
        System.out.println(Arrays.toString(array));
    }
}
