package com.topic.array;

import com.util.Best;
import com.util.Question;
import com.util.Self;

@Question(id = 122, title = "Best Time to Buy and Sell Stock II", hint = "" +
        "1. may complete as many transactions(eg. buy one and sell one share of the stock multiple times)" +
        "2. not engage in multiple transactions at the same time(eg. you must sell the stock before you buy again)")
public class EBestTimetoBuyandSellStockII {

    @Best
    @Self(thought = "[Bad][Confuse] can buy and sell in one day", complexity = "O(n)")
    static int solution(int[] prices) {

        if(prices == null || prices.length <= 1){
            return 0;
        }

        int len = prices.length, max = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] > prices[i - 1])
                max += prices[i] - prices[i - 1];
        }
        return max;
    }

    public static void main(String[] args){
        int[] nums = {7, 1, 5, 3, 6, 4};
        System.out.println(solution(nums));
    }

}
