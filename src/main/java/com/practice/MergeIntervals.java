package com.practice;

import com.support.Interval;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {

    public static List<Interval> merge(List<Interval> intervals) {

        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

        List<Interval> result = new LinkedList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (interval.start <= end) // Overlapping intervals, move the end if needed
                end = Math.max(end, interval.end);
            else {                     // Disjoint intervals, add the previous one and reset bounds
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        // Add the last interval
        result.add(new Interval(start, end));
        return result;

    }

    public static void main(String[] args){
        // [[1,3], [2,6], [8,10], [15,18]]
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 3));
        input.add(new Interval(15,18));
        input.add(new Interval(8,10));
        input.add(new Interval(2,6));
        System.out.println(merge(input));
    }
}
