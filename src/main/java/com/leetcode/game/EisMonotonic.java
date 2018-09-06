package com.leetcode.game;

public class EisMonotonic {

    public static boolean isMonotonic(int[] A) {
        boolean inc = true, des = true;
        for(int i = 1; i < A.length; i++){
            inc &= (A[i] - A[i - 1]) >= 0;
            des &= (A[i] - A[i - 1]) <= 0;
        }
        return inc || des;
    }

    public static void main(String[] args){
        int[] nums = {6, 5, 4, 4};
        System.out.println(isMonotonic(nums));
    }
}
