package com.leetcode.prime;

import com.support.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class EMeetingRooms {

    public static boolean needOneMoreRoom(Interval[] intervals){
        if(intervals == null || intervals.length == 0){
            return false;
        }
        Arrays.sort(intervals, Comparator.comparingInt(i -> i.start));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int rooms = 0;
        for (int i = 0; i < intervals.length; i++) {
            pq.offer(intervals[i].end);
            if (intervals[i].start < pq.peek()) { // 开始时间小于最早结束时间, 需要增加 room
                rooms ++;
                if(rooms > 1){
                    return false;
                }
            } else {
                pq.poll(); // 允许最早时间结束后, 去掉
            }
        }
        return true;
    }

    public static void main(String[] args){
        Interval[] bookingTimes = {new Interval(0, 30), new Interval(5, 10), new Interval(15, 20)};
        System.out.println(needOneMoreRoom(bookingTimes));
    }

}
