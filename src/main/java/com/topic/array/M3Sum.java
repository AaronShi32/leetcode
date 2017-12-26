package com.topic.array;

import com.util.Best;
import com.util.Question;
import com.util.Self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Question(id = 15, title = "3Sum", hint = "" +
        "1. Find all unique triplets in the array which a + b + c = 0" +
        "2. The solution set must not contain duplicate triplets.")
public class M3Sum {

    @Best
    @Self(thought = "sort + binary serach", complexity = "O(n)")
    static List<List<Integer>> solution(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i + 2 < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            int target = -nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
                    while (j < k && nums[k] == nums[k + 1]) k--;  // skip same result
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        Integer a = new Integer(1);
        System.out.println(a.hashCode());
    }

}
