package com.practice;

import com.util.Question;

import java.util.*;

@Question(id = 752)
public class MOpentheLock {

    public int openLock(String[] deadends, String target) {
        Set<String> deadset = new HashSet<>(Arrays.asList(deadends));
        Map<String, Integer> costs = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        costs.put("0000", 0);
        while(!q.isEmpty()) {
            String cur = q.poll();
            if (deadset.contains(cur))
                continue;
            if (cur.equals(target))
                break;
            int cost = costs.get(cur);
            for(int i = 0; i < 4; i++) {
                char[] chars = cur.toCharArray();
                chars[i] = (char)(chars[i] == '0' ? '9' : chars[i] - 1);
                String node = new String(chars);
                if (!costs.containsKey(node)) {
                    q.offer(node);
                    costs.put(node, cost + 1);
                }

                chars = cur.toCharArray();
                chars[i] = (char)(chars[i] == '9' ? '0' : chars[i] + 1);
                node = new String(chars);
                if (!costs.containsKey(node)) {
                    q.offer(node);
                    costs.put(node, cost + 1);
                }
            }
        }

        return costs.getOrDefault(target, -1);
    }

}
