package com.topic.map;

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

        List<String> result = new ArrayList<>();

        Map<String, Integer> word2count = new HashMap<>();

        for(String word : words){
            word2count.put(word, word2count.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : a.getValue() - b.getValue()
        );

        for(Map.Entry<String, Integer> entry: word2count.entrySet()){
            pq.offer(entry);
            if( pq.size() > k )
                pq.poll();
        }

        while(!pq.isEmpty())
            result.add(pq.poll().getKey());

        return result;

    }

    public static void main(String[] args){

        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};

        System.out.println(topKFrequent(words, 2));

    }
}
