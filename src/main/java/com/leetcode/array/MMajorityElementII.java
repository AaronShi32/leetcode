package com.leetcode.array;

import com.util.Best;
import com.util.Question;
import com.util.Self;

import java.util.*;

@Question(id = 229, title = "Majority Element II", hint = "" +
        "find all elements that appear more than ⌊ n/3 ⌋ times" +
        "The algorithm should run in linear time and in O(1) space.")
public class MMajorityElementII {

    @Best(thought = "there is only two element appear more than ⌊ n/3 ⌋ times", complexity = "O(n)")
    static List<Integer> leetcode(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();
        List<Integer> ret = new ArrayList<>();
        int number1 = nums[0], number2 = nums[0], count1 = 0, count2 = 0, len = nums.length;
        // get two most appear element: number1, number2
        for (int i = 0; i < len; i++) {
            if (nums[i] == number1)
                count1++;
            else if (nums[i] == number2)
                count2++;
            else if (count1 == 0) {
                number1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                number2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        // whether number1, number2 appear more than ⌊ n/3 ⌋ times
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == number1)
                count1++;
            else if (nums[i] == number2)
                count2++;
        }
        if (count1 > len / 3)
            ret.add(number1);
        if (count2 > len / 3)
            ret.add(number2);
        return ret;
    }



    @Self(thought = "[Robustness] HashMap<value, count>", complexity = "O(n)")
    static List<Integer> solution(int[] nums){
        int threshold = nums.length / 3;
        List<Integer> ret = new ArrayList<>();
        if(threshold < 1){
            for(int n : nums){
                if(!ret.contains(n))
                    ret.add(n);
            }
            return ret;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            if(map.containsKey(n)){
                map.put(n, map.get(n) + 1);
                if(map.get(n) > threshold && !ret.contains(n)){
                    ret.add(n);
                }
            }else{
                map.put(n, 1);
            }
        }
        return ret;

    }

    public static void main(String[] args){
        int[] nums = {3,2,3,2,5,2,3,2,3,2};
        System.out.println(solution(nums));
    }

}
