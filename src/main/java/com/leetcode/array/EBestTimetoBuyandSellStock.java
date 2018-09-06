package com.leetcode.array;

import com.util.Best;
import com.util.Question;
import com.util.Self;

@Question(id = 121, title = "Best Time to Buy and Sell Stock", hint = "" +
        "1. ith element is the price of a given stock on day i" +
        "2. only permitted to complete at most one transaction")
public class EBestTimetoBuyandSellStock {

    @Best
    @Self(thought = "to record min (buy), and use max to record (current - min)", complexity = "O(n)")
    static int solution(int[] prices) {

        if(prices == null || prices.length <= 1){
            return 0;
        }

        int len = prices.length, max = 0, min = prices[0];
        for(int i = 1; i < len; i++){
            min = Math.min(prices[i], min);
            max = Math.max(prices[i] - min, max);
        }
        return max;
    }

    public static void main(String[] args){
        int[] nums = {7, 1, 5, 3, 6, 4};
        System.out.println(solution(nums));
    }

}
