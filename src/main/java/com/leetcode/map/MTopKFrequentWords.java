package com.leetcode.map;

import com.util.Question;

import java.util.*;

/**
 * 使用优先队列实现最大堆, 最小堆
 *
 * 比较器 Comparator
 *
 *
 */

@Question(id = 692, hint = "Given a non-empty list of words, return the k most frequent elements.")
public class MTopKFrequentWords {

    public static List<String> topKFrequent(String[] words, int k) {

        List<String> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(String s: words){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) ->
                a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()
        );

        for(Map.Entry<String, Integer> entry: map.entrySet()){
            pq.offer(entry);
            if( pq.size() > k )
                pq.poll();
        }
        while(!pq.isEmpty()){
            ans.add(0, pq.poll().getKey());
        }
        return ans;

    }

    public static void main(String[] args){

        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};

        System.out.println(topKFrequent(words, 2));

    }
}
