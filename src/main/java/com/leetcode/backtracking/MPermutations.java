package com.topic.backtracking;

import com.util.Question;

import java.util.ArrayList;
import java.util.List;

@Question(id = 46, title = "Permutations", hint = "Given a collection of distinct integers, return all possible permutations.")
public class MPermutations {

    public List<List<Integer>> permuteIterative(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        backtrack(ret, new ArrayList<>(), nums);
        return ret;
    }

    private void backtrack(List<List<Integer>> ret, List<Integer> tmp, int[] nums){
        if(tmp.size() == nums.length){ // condition
            ret.add(new ArrayList<>(tmp));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tmp.contains(nums[i])) continue; // element already exists, skip
                tmp.add(nums[i]);
                backtrack(ret, tmp, nums);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

}
