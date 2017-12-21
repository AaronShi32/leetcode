package com.topic.array;

import com.util.Question;

@Question(id = 123, title = "Best Time to Buy and Sell Stock III", hint = "" +
        "1. You may complete at most two transactions" +
        "2. not engage in multiple transactions at the same time")
public class EBestTimetoBuyandSellStockIII {

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

    public static void main(String[] args){
//        int[] nums = {1,2,3,4,5,4};
//        System.out.println(solution(nums));
    }

}
