package com.topic.array;

import com.support.Interval;
import com.util.Best;
import com.util.Question;
import com.util.Self;

import java.util.*;

@Question(id = 56, title = "Merge Intervals", hint = "" +
        "1. Given a collection of intervals, merge all overlapping intervals")
public class MMergeIntervals {

    @Best
    @Self(thought = "sort + travel")
    public List<Interval> solution(List<Interval> intervals) {
        if (intervals.size() <= 1)
            return intervals;

        // Sort by ascending starting point using an anonymous Comparator
        intervals.sort(Comparator.comparingInt(i -> i.start));

        List<Interval> result = new LinkedList<Interval>();
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

    }

}
