package com.topic.array;

import com.util.Self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MSubsets {

    @Self(thought = "dfs", complexity = "")
    static List<List<Integer>> solution(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }


    public static void main(String[] args){
        int h;
        System.out.println((h = 20) ^ (h >>> 16));

    }

}
