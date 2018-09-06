package com.leetcode.array;

import com.util.Best;
import com.util.Question;
import com.util.Self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Question(id = 39, title = "Combination Sum", hint = "" +
        "1. a set of candidate numbers (C) (without duplicates)" +
        "2. find all unique combinations in C where the candidate numbers sums to T." +
        "3. All numbers (including target) will be positive integers." +
        "4. The solution set must not contain duplicate combinations")
public class MCombinationSum {

    @Best(thought = "dp", complexity = "")
    static void leetcode(){

    }

    @Self(thought = "miss", complexity = "")
    static List<List<Integer>> solution(int[] nums, int target){
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> candidates = new ArrayList<>();
        int left = 0, right = nums.length - 1, len = nums.length;
        for(int i = 0; i < len; i++){
            int times = target / nums[i];
            if(times == 0){
                continue;
            }
            for(int add = 0; add < times; add ++){
                candidates.add(nums[i]);
            }
        }
        if(candidates.size() == 0){
            return ret;
        }
        Integer[] numss = candidates.toArray(new Integer[0]);
        Arrays.sort(numss);
        int sum = 0;
        for(int i = 0; i < numss.length; i++){
            sum += numss[i];
            if(sum == target){

            }else if(sum > target){
                sum -= numss[i];
            }else{

            }
        }
        return ret;
    }


    public static void main(String[] args){
        int h;
        System.out.println((h = 20) ^ (h >>> 16));
    }


}
