package com.hit.basmath.learn.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 381. Insert Delete GetRandom O(1) - Duplicates allowed
 * <p>
 * Design a data structure that supports all following operations in average O(1) time.
 * <p>
 * Note: Duplicate elements are allowed.
 * <p>
 * insert(val): Inserts an item val to the collection.
 * remove(val): Removes an item val from the collection if present.
 * getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.
 * <p>
 * Example:
 * <p>
 * // Init an empty collection.
 * RandomizedCollection collection = new RandomizedCollection();
 * <p>
 * // Inserts 1 to the collection. Returns true as the collection did not contain 1.
 * collection.insert(1);
 * <p>
 * // Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
 * collection.insert(1);
 * <p>
 * // Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
 * collection.insert(2);
 * <p>
 * // getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
 * collection.getRandom();
 * <p>
 * // Removes 1 from the collection, returns true. Collection now contains [1,2].
 * collection.remove(1);
 * <p>
 * // getRandom should return 1 and 2 both equally likely.
 * collection.getRandom();
 */
public class _381 {
    public class RandomizedCollection {
        ArrayList<Integer> nums;
        HashMap<Integer, Set<Integer>> locs;
        java.util.Random rand = new java.util.Random();

        /**
         * Initialize your data structure here.
         */
        public RandomizedCollection() {
            nums = new ArrayList<Integer>();
            locs = new HashMap<Integer, Set<Integer>>();
        }

        /**
         * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
         */
        public boolean insert(int val) {
            boolean contain = locs.containsKey(val);
            if (!contain) locs.put(val, new LinkedHashSet<Integer>());
            locs.get(val).add(nums.size());
            nums.add(val);
            return !contain;
        }

        /**
         * Removes a value from the collection. Returns true if the collection contained the specified element.
         */
        public boolean remove(int val) {
            boolean contain = locs.containsKey(val);
            if (!contain) return false;
            int loc = locs.get(val).iterator().next();
            locs.get(val).remove(loc);
            if (loc < nums.size() - 1) {
                int lastone = nums.get(nums.size() - 1);
                nums.set(loc, lastone);
                locs.get(lastone).remove(nums.size() - 1);
                locs.get(lastone).add(loc);
            }
            nums.remove(nums.size() - 1);

            if (locs.get(val).isEmpty()) locs.remove(val);
            return true;
        }

        /**
         * Get a random element from the collection.
         */
        public int getRandom() {
            return nums.get(rand.nextInt(nums.size()));
        }
    }
}
