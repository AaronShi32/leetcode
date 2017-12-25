package com.topic.array;

import com.util.Best;
import com.util.Question;
import com.util.Self;

@Question(id = 123, title = "Best Time to Buy and Sell Stock III", hint = "" +
        "1. You may complete at most two transactions" +
        "2. not engage in multiple transactions at the same time")
public class HBestTimetoBuyandSellStockIII {


    @Best(thought = "DP", complexity = "O(n)")
    static int leetcode(int[] prices) {

        int firstBuy = Integer.MIN_VALUE, firstSell = 0;
        int secondBuy = Integer.MIN_VALUE, secondSell = 0;

        for (int curPrice : prices) {
            if (firstBuy < -curPrice) firstBuy = -curPrice; // the max profit after you buy first stock
            if (firstSell < firstBuy + curPrice) firstSell = firstBuy + curPrice; // the max profit after you sell it
            if (secondBuy < firstSell - curPrice) secondBuy = firstSell - curPrice; // the max profit after you buy the second stock
            if (secondSell < secondBuy + curPrice) secondSell = secondBuy + curPrice; // the max profit after you sell the second stock
        }

        return secondSell;
    }

    @Self(thought = "miss")
    static int solution(int[] prices){
        return -1;
    }

    public static void main(String[] args){
        int[] nums = {7, 1, 5, 3, 6, 4};
        System.out.println(leetcode(nums));
    }

}
