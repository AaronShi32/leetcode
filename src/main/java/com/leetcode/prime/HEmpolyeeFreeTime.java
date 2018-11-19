package com.leetcode.prime;

import com.support.Interval;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class HEmpolyeeFreeTime {

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start);//按照第一个元素升序排列
        schedule.forEach(e -> pq.addAll(e));//lamdba表达式，将schedule的每个元素的每个子元素加入pq中
        Interval before = pq.poll();
        while (!pq.isEmpty()) {
            if (before.end < pq.peek().start) {
                res.add(new Interval(before.end, pq.peek().start));
                before = pq.poll();
            } else {
                before = before.end < pq.peek().end ? pq.peek() : before;//这里不能写成before = before.end < pq.peek().end ? pq.poll() : before;会Time Limit Exceeded
                pq.poll();
            }
        }
        return res;
    }
}
