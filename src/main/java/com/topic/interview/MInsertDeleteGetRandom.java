package com.topic.interview;

import com.util.Question;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Question(id = 380, hint = "Design a data structure that supports all following operations in average O(1) time.")
public class MInsertDeleteGetRandom {

    /**
     * Map and ArrayList to impl
     */

    private Set<Integer> s;

    private Random rand;


    /** Initialize your data structure here. */
    public MInsertDeleteGetRandom() {
        s = new HashSet<>();
        rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        return s.add(val);
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        return s.remove(val);
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return (int)s.toArray()[rand.nextInt(s.size())];
    }
}
