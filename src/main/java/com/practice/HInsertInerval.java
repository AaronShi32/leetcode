package com.practice;

import com.support.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HInsertInerval {

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ans = new ArrayList<>();

        if(intervals == null){
            return ans;
        }

        intervals.sort(Comparator.comparingInt(i -> i.start));

        int i = 0;
        // add all the intervals ending before newInterval starts
        while (i < intervals.size() && intervals.get(i).end < newInterval.start)
            ans.add(intervals.get(i++));
        // merge all overlapping intervals to one considering newInterval
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval = new Interval( // we could mutate newInterval here also
                    Math.min(newInterval.start, intervals.get(i).start),
                    Math.max(newInterval.end, intervals.get(i).end));
            i++;
        }
        ans.add(newInterval); // add the union of intervals we got
        // add all the rest
        while (i < intervals.size()) ans.add(intervals.get(i++));
        return ans;

    }

    public static void main(String[] args){
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(6,9));
        Interval interval = new Interval(2,5);
        System.out.println(insert(intervals, interval));
    }

}
