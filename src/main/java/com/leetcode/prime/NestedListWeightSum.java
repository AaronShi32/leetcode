package com.leetcode.prime;

import com.support.NestedInteger;

import java.util.List;

public class NestedListWeightSum {

    public int depthSum(List<NestedInteger> nestedIntegerList){
        int res = helper(nestedIntegerList, 1);
        return res;
    }

    private int helper(List<NestedInteger> nestedIntegerList, int weight){
        int sum = 0;
        for(NestedInteger item: nestedIntegerList){
            if(item.isInteger()){
                sum += item.getInteger() * weight;
            }else{
                sum += helper(item.getList(), weight + 1);
            }
        }
        return sum;
    }

}
