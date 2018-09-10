package com.leetcode.prime;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsk {


    public static int PRATICE(int[] nums, int K){
        if(nums == null || nums.length == 0){
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int sum = 0, max = -1;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            int lookingfor = sum - K;
            if(map.containsKey(lookingfor)){
                int start = map.get(lookingfor);
                max = Math.max(max, i - start + 1);
            }
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        if(max == -1){
            return 0;
        }
        return max;
    }



    public static int maximumSizeSubarraySumEquals(int[] nums, int K){
        if(nums == null || nums.length == 0){
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int sum = 0,  max = -1;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            int lookingfor = sum - K;
            if(map.containsKey(lookingfor)){
                int start = map.get(lookingfor);
                max = Math.max(max, i - start + 1);
            }
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        if(max == -1){
            return 0;
        }
        return max;
    }

    public static void main(String[] args){
        int[] nums = {1, -1, 5, -2, 3};
        System.out.println(maximumSizeSubarraySumEquals(nums, 3));
    }
}
