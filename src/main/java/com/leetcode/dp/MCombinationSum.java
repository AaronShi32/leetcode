package com.topic.dp;

import com.util.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Question(id = 39, title = "Combination Sum", hint = "" +
        "1. Given a set of candidate numbers (C) (without duplicates) and a target number (T)" +
        "2. find all unique combinations in C where the candidate numbers sums to T" +
        "3. The same repeated number may be chosen from C unlimited number of times.")
public class MCombinationSum {

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args){
        System.out.println(combinationSum(new int[]{2,3,4,5,21,5,35,6}, 24));
    }

}
