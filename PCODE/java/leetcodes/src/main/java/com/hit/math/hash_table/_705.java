package com.hit.math.hash_table;

/**
 * 705. Design HashSet
 * <p>
 * Design a HashSet without using any built-in hash table libraries.
 * <p>
 * To be specific, your design should include these functions:
 * <p>
 * add(value): Insert a value into the HashSet.
 * contains(value) : Return whether the value exists in the HashSet or not.
 * remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.
 * <p>
 * Example:
 * <p>
 * MyHashSet hashSet = new MyHashSet();
 * hashSet.add(1);
 * hashSet.add(2);
 * hashSet.contains(1);    // returns true
 * hashSet.contains(3);    // returns false (not found)
 * hashSet.add(2);
 * hashSet.contains(2);    // returns true
 * hashSet.remove(2);
 * hashSet.contains(2);    // returns false (already removed)
 * <p>
 * Note:
 * <p>
 * All values will be in the range of [0, 1000000].
 * The number of operations will be in the range of [1, 10000].
 * Please do not use the built-in HashSet library.
 */
public class _705 {
    class MyHashSet {
        private int buckets = 1000;
        private int itemsPerBucket = 1001;
        private boolean[][] table;

        /**
         * Initialize your data structure here.
         */
        public MyHashSet() {
            table = new boolean[buckets][];
        }

        public int hash(int key) {
            return key % buckets;
        }

        public int pos(int key) {
            return key / buckets;
        }

        public void add(int key) {
            int hashkey = hash(key);

            if (table[hashkey] == null) {
                table[hashkey] = new boolean[itemsPerBucket];
            }
            table[hashkey][pos(key)] = true;
        }

        public void remove(int key) {
            int hashkey = hash(key);

            if (table[hashkey] != null)
                table[hashkey][pos(key)] = false;
        }

        /**
         * Returns true if this set did not already contain the specified element
         */
        public boolean contains(int key) {
            int hashkey = hash(key);
            return table[hashkey] != null && table[hashkey][pos(key)];
        }
    }
}
