package com.practice;

import java.util.Arrays;
import java.util.Random;

//最坏: n(n-1)/2
public class QuickSort {

    private static Random random = new Random();

    private static int partition(int[] nums, int start, int end){
        int r = random.nextInt(end - start) + start;
        swap(nums, start, r);
        int pvt = nums[start];
        r = start;
        for(int i = start + 1; i <= end; i++){
            if(pvt > nums[i]){
                r ++;
                swap(nums, r, i);
            }
        }
        swap(nums, r, start);
        return r;
    }


    private static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static void sort(int[] nums, int start, int end){
        if(start < end){
            int r = partition(nums, start, end);
            sort(nums, start, r - 1);
            sort(nums, r + 1, end);
        }
    }


    public static void main(String[] args){
        int[] array = {99,5,32,6,34,6,23,76,587,354,213,62,43,64,124,124,6,47,346,234,0};
        sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
