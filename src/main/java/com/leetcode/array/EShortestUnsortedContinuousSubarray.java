package com.leetcode.array;

import com.util.Best;
import com.util.Question;
import com.util.Self;

@Question(id = 581, title = "Shortest Unsorted Continuous Subarray", hint = "" +
        "1. find one continuous subarray that if you only sort this subarray in ascending order" +
        "2. then the whole array will be sorted in ascending order")
public class EShortestUnsortedContinuousSubarray {

    @Best
    @Self(thought = "min and max")
    public static int solution(int[] A){
        int n = A.length, beg = -1, end = -2, min = A[n-1], max = A[0];
        for (int i=1;i<n;i++) {
            max = Math.max(max, A[i]);
            min = Math.min(min, A[n-1-i]);
            if (A[i] < max) end = i;
            if (A[n-1-i] > min) beg = n-1-i;
        }
        return end - beg + 1;
    }


    public static void main(String[] args){

    }
}
