package com.hit.basmath.learn.hash_table;

import java.util.*;

/**
 * 380. Insert Delete GetRandom O(1)
 * <p>
 * Design a data structure that supports all following operations in average O(1) time.
 * <p>
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 * <p>
 * Example:
 * <p>
 * // Init an empty set.
 * RandomizedSet randomSet = new RandomizedSet();
 * <p>
 * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomSet.insert(1);
 * <p>
 * // Returns false as 2 does not exist in the set.
 * randomSet.remove(2);
 * <p>
 * // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomSet.insert(2);
 * <p>
 * // getRandom should return either 1 or 2 randomly.
 * randomSet.getRandom();
 * <p>
 * // Removes 1 from the set, returns true. Set now contains [2].
 * randomSet.remove(1);
 * <p>
 * // 2 was already in the set, so return false.
 * randomSet.insert(2);
 * <p>
 * // Since 2 is the only number in the set, getRandom always return 2.
 * randomSet.getRandom();
 */
public class _380 {
    class RandomizedSet {
        private Map<Integer, Integer> dict;
        private List<Integer> list;
        private Random rand = new Random();

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            dict = new HashMap<>();
            list = new ArrayList<>();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (dict.containsKey(val)) return false;

            dict.put(val, list.size());
            list.add(list.size(), val);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (!dict.containsKey(val)) return false;

            // move the last element to the place idx of the element to delete
            int lastElement = list.get(list.size() - 1);
            int idx = dict.get(val);
            list.set(idx, lastElement);
            dict.put(lastElement, idx);
            // delete the last element
            list.remove(list.size() - 1);
            dict.remove(val);
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            return list.get(rand.nextInt(list.size()));
        }
    }
}
