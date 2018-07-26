package com.leetcode.basic;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    private static int[] array = {99,5,32,6,34,6,23,76,587,354,213,62,43,64,124,124,6,47,346,234,0};
    private static Random random = new Random();

    private static void swap(int x, int y) {
        int tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
    }

    private static int partition(int start, int end){
        int r = random.nextInt(end - start) + start; // random quick sort
        swap(start, r);
        int pivot = array[start];
        r = start;
        System.out.println("r: " + r + " pivot: " + pivot);
        for (int i = start + 1; i <= end; i++) {
            if (array[i] <= pivot) {
                r += 1;
                swap(r, i);
                System.out.println("Swap at " + i + " Now: " + Arrays.toString(array));
            }
        }
        swap(start, r);
        System.out.println("Partition at " + r + " Now: " + Arrays.toString(array));
        return r;

    }

    private static void sort(int start, int end){
        if(start < end){
            int r = partition(start, end);
            sort(start, r - 1);
            sort(r + 1, end);
        }

    }

    public static void main(String[] args){
        int len = array.length;
        sort(0, len - 1);
        System.out.println(Arrays.toString(array));
    }


}
