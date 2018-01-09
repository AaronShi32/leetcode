package com.topic.array;

import com.util.Self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EIntersectionofTwoArraysII {

    @Self(thought = "sort + travel", complexity = "")
    static int[] solution(int[] nums1, int[] nums2){
        List<Integer> ret = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n1 = nums1.length, n2 = nums2.length;
        for(int i = 0, j = 0; i < n1 && j < n2;){
            if(nums1[i] == nums2[j]){
                ret.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i] < nums2[j]){
                i++;
            }else{
                j++;
            }
        }
        int[] result = new int[ret.size()];
        for(int i = 0; i < ret.size(); i++){
            result[i] = ret.get(i);
        }
        return result;
    }


    public static void main(String[] args){
        int h;
        System.out.println((h = 20) ^ (h >>> 16));

    }

}
