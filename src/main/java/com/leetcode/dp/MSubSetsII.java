package com.leetcode.dp;

import com.util.Question;
import com.util.Self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Question(id = 90, title = "Subsets II", hint = "has duplicate")
public class MSubSetsII {

    @Self(thought = "dfs", complexity = "")
    static List<List<Integer>> solution(int[] nums){
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list , List<Integer> dp, int [] nums, int start){
        list.add(new ArrayList<>(dp));
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i - 1]) continue;
            dp.add(nums[i]);
            backtrack(list, dp, nums, i + 1);
            dp.remove(dp.size() - 1);
        }
    }


    public static void main(String[] args){
        int h;
        System.out.println((h = 20) ^ (h >>> 16));

    }

}
