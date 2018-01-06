package com.topic.interview;

import com.util.Best;
import com.util.Question;
import com.util.Self;

import java.util.Arrays;
import java.util.Comparator;

@Question(id = 179, title = "Largest Number")
public class MLargestNumber {

    @Best(thought = "largest operation use String")
    public static String leetcode(int[] num){
        if(num == null || num.length == 0)
            return "";

        // Convert int array to String array, so we can sort later on
        String[] s_num = new String[num.length];
        for(int i = 0; i < num.length; i++)
            s_num[i] = String.valueOf(num[i]);

        // Comparator to decide which string should come first in concatenation
        Comparator<String> comp = new Comparator<String>(){
            @Override
            public int compare(String str1, String str2){
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s2.compareTo(s1); // reverse order here, so we can do append() later
            }
        };

        Arrays.sort(s_num, comp);
        // An extreme edge case by lc, say you have only a bunch of 0 in your int array
        if(s_num[0].charAt(0) == '0')
            return "0";

        StringBuilder sb = new StringBuilder();
        for(String s: s_num)
            sb.append(s);

        return sb.toString();
    }


    @Self(thought = "Runtime Error", complexity = "O(n)")
    public static String solution(int[] nums) {
        int len = nums.length;
        String max = String.valueOf(nums[0]);
        for(int i = 1, j; i < len; i++){
            max = String.valueOf(Math.max(Integer.parseInt(max + nums[i]), Integer.parseInt(nums[i] + max)));
        }
        return max;
    }

    public static void main(String[] args){
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(solution(nums));
    }

}
