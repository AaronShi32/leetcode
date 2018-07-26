package com.topic.interview;

public class FindKth {

    private static int[] array = {99,5,32,6,34,6,23,76,587,354,213,62,43,64,124,124,6,47,346,234,0};


    private static void findKthSmaller(int K, int start, int end){
        int i = start, j = end;
        int pivot = array[start];
        while(i < j){
            while (i < j && array[j] >= pivot){
                j--;
            }
            if(array[j] < pivot){
                array[i++] = array[j];
            }
            while (i < j && array[i] < pivot){
                i++;
            }
            if(array[i] >= pivot){
                array[j--] = array[i];
            }
        }
        array[i] = pivot;
        if(K - 1 < i) {
            findKthSmaller(K,start,i-1);
        }
        else if(K - 1 > i) {
            findKthSmaller(K,i+1,end);
        }
        else
            System.out.println(array[K-1]);
            return;
    }

    private static void findKthLarger(int K, int start, int end){
        int i = start, j = end;
        int pivot = array[start];
        while(i < j){
            while (i < j && array[j] < pivot){
                j--;
            }
            if(array[j] < pivot){
                array[i++] = array[j];
            }
            while (i < j && array[i] >= pivot){
                i++;
            }
            if(array[i] >= pivot){
                array[j--] = array[i];
            }
        }
        array[i] = pivot;
        if(K - 1 < i) {
            findKthLarger(K,start,i-1);
        }
        else if(K - 1 > i) {
            findKthLarger(K,i+1,end);
        } else {
            System.out.println(array[K - 1]);
        }
        return;
    }

    public static void main(String[] args){
        int len = array.length - 1;
        findKthSmaller(10,0,len);
        findKthLarger(11,0,len);
    }

}
