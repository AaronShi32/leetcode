package com.topic.dp;

import com.util.Question;

import java.util.ArrayList;
import java.util.List;

@Question(id = 216, title = "Combination Sum III", hint = "" +
        "1. Find all possible combinations of k numbers that add up to a number n." +
        "2. given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers")
public class MCombinationSumIII {

    public static List<List<Integer>> solution(int k, int target){
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, target, 1);
        return result;

    }

    private static void backtrack(List<List<Integer>> result, List<Integer> record, int k, int target, int start) {
        if(target < 0 || record.size() > k){
            return;
        }
        if(target == 0 && record.size() == k){
            result.add(new ArrayList<>(record));
        }
        for(int i = start; i <= 9; i++){
            record.add(i);
            backtrack(result, record, k, target - i, i + 1);
            record.remove(record.size() - 1);
        }
        return;
    }


    public static void main(String[] args){
        System.out.print(solution(3,7));
    }
}
