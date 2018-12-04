package com.leetcode.prime;

import com.util.Self;

import java.util.*;

public class HAlienDictionary {

    public String alienOrder(String[] words) {
        StringBuilder order = new StringBuilder();
        if (words == null) {
            throw new IllegalArgumentException("");
        }
        if (words.length == 0) {
            order.toString();
        }
        Map<Character/*char*/, Set<Character/*char*/>> map = new HashMap<>();
        Map<Character/*char*/, Integer/*indegree*/> indegree = new HashMap<>();

        intialize(words, map, indegree);

        buildGraph(words, map, indegree);

        sort(order, map, indegree);

        return order.length() == indegree.size() ? order.toString() : "";
    }

    private void intialize(String[] words, Map<Character/*char*/, Set<Character/*char*/>> map, Map<Character/*char*/, Integer/*indegree*/> indegree) {
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!map.containsKey(c)) {
                    map.put(c, new HashSet<>());
                }
                if (!indegree.containsKey(c)) {
                    indegree.put(c, 0);
                }
            }
        }
    }

    private void buildGraph(String[] words, Map<Character/*char*/, Set<Character/*char*/>> map, Map<Character/*char*/, Integer/*indegree*/> indegree) {
        Set<String/*edge*/> edges = new HashSet<>();
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            for (int j = 0; j < w1.length() && j < w2.length(); j++) {
                char from = w1.charAt(j);
                char to = w2.charAt(j);
                if (from == to) {
                    continue;
                }
                String edge = from + "" + to;
                if (!edges.contains(edge)) {
                    Set<Character> set = map.get(from);
                    set.add(to);
                    indegree.put(to, indegree.getOrDefault(to, 0) + 1);
                    edges.add(edge);
                    break;
                }
            }
        }
    }

    private void sort(StringBuilder order, Map<Character/*char*/, Set<Character/*char*/>> map, Map<Character/*char*/, Integer/*indegree*/> indegree) {
        Queue<Character> queue = new LinkedList<>();
        //for (Map.Entry entry: indegree.entrySet()) {
        for (Map.Entry<Character/*char*/, Integer/*indegree*/> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }
        while (!queue.isEmpty()) {
            char w = queue.poll();
            order.append(w);
            Set<Character> set = map.get(w);
            for (char c : set) {
                int degree = indegree.get(c);
                if (degree != 0) {
                    degree = degree - 1;
                    if (degree == 0) {
                        queue.offer(c);
                    }
                    indegree.put(c, degree);
                }
            }
        }
    }

    @Self
    public static String alienOrderSelf(String[] words) {

        if (words == null || words.length == 0)
            return "";

        int[][] graph = new int[26][26];
        int[] indegree = new int[26];
        HashSet<Character> alphets = new HashSet<>();

        // build graph
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            for (int j = 0; j < w1.length() && j < w2.length(); j++) {

                alphets.add(w1.charAt(j));
                alphets.add(w2.charAt(j));

                int out = w1.charAt(j) - 'a';
                int in = w2.charAt(j) - 'a';
                if (out == in) continue;
                if (graph[out][in] == 0) {
                    indegree[in]++;
                }
                graph[out][in] = 1;
            }
        }

        // select node
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (indegree[i] == 0 && alphets.contains((char) (i + 'a'))) {
                q.offer(i);
            }
        }

        // sort
        StringBuilder order = new StringBuilder();
        while (!q.isEmpty()) {
            int n = q.poll();
            order.append((char) (n + 'a'));
            for (char c : alphets) {
                int in = c - 'a';
                if (graph[n][in] != 0) {
                    indegree[in]--;
                    if (indegree[in] == 0) {
                        q.offer(in);
                    }
                    graph[n][in] = 0;
                }
            }
        }

        return order.length() == alphets.size() ? order.toString() : "-1";

    }

    public static void main(String[] args) {
        String[] words = {
                "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"
        };

        String order = alienOrderSelf(words);
        System.out.println(order);
    }

}
