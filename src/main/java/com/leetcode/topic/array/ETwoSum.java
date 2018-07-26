package com.leetcode.topic.array;

import com.util.Best;
import com.util.Question;
import com.util.Self;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


@Question(id = 1, title = "Two Sum", hint = "each input would have exactly one solution, and you may not use the same element twice")
public class ETwoSum {

    @Best(thought = "hashMap, key = nums[i], value = index", complexity = "O(n)")
    static int[] leetcode(int[] nums, int target){
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }


    @Self(thought = "brute force", complexity = "O(n2)")
    static int[] solution(int[] nums, int target){
        int left = 0, right = 0;
        int sum = 0;
        int len = nums.length;
        for(; left < len; left++){
            for(right = left + 1; right < len; right++){
                sum = nums[left] + nums[right];
                if(sum == target){
                    return new int[]{left, right};
                }
            }
        }
        return null;
    }

    public static void main(String[] args){
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(solution(nums, 9)));
        System.out.println(Arrays.toString(leetcode(nums, 9)));
    }
}
