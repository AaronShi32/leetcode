package com.leetcode.prime;

import com.support.NestedInteger;

import java.util.List;

public class NestedListWeightSumII {

    int maxDepth = 0;

    public int depthSum(List<NestedInteger> nestedIntegerList){
        depth(nestedIntegerList, 1);
        return helper(nestedIntegerList, maxDepth);
    }

    private int helper(List<NestedInteger> nestedIntegerList, int weight){
        int sum = 0;
        for(NestedInteger item: nestedIntegerList){
            if(item.isInteger()){
                sum += item.getInteger() * weight;
            }else{
                sum += helper(nestedIntegerList, weight - 1);
            }
        }
        return sum;

    }

    private void depth(List<NestedInteger> nestedIntegerList, int depth){

        if(depth > maxDepth)
            maxDepth = depth;

        for(NestedInteger item: nestedIntegerList){
            if(!item.isInteger()){
                depth(item.getList(), depth + 1);
            }
        }
    }

}
