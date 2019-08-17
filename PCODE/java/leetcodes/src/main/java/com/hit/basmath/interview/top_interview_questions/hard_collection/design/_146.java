package com.hit.basmath.interview.top_interview_questions.hard_collection.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 146. LRU Cache
 * <p>
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * <p>
 * The cache is initialized with a positive capacity.
 * <p>
 * Follow up:
 * <p>
 * Could you do both operations in O(1) time complexity?
 * <p>
 * Example:
 * <p>
 * LRUCache cache = new LRUCache( 2 // capacity );
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // returns 1
 * cache.put(3,3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4,4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 */
public class _146 {
    class LRUCache {
        private PriorityQueue<List<Integer>> queue; //list.get(0)=key; list.get(1)=value; list.get(2)=priority;
        private HashMap<Integer, List<Integer>> map; //map.key=key; map.value=<<List>Integer>([key,value,priority]);
        private List<Integer> listRetrieved;
        private List<Integer> listAdded;
        private int capacity;
        private int priority;

        public LRUCache(int capacity) {
            queue = new PriorityQueue<>((a, b) -> a.get(2) - b.get(2));
            map = new HashMap();
            this.capacity = capacity;
            priority = 0;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                listRetrieved = map.get(key);
                queue.remove(listRetrieved);
                listAdded = new ArrayList() {{
                    add(key);
                    add(listRetrieved.get(1));
                    add(++priority);
                }};
                queue.add(listAdded);
                map.put(key, listAdded);
                return listRetrieved.get(1);
            }
            return -1;
        }

        public void put(int key, int value) {
            listAdded = new ArrayList() {{
                add(key);
                add(value);
                add(++priority);
            }};
            if (map.containsKey(key)) {
                queue.remove(map.get(key));
            } else if (queue.size() >= capacity) {
                listRetrieved = queue.poll();
                map.remove(listRetrieved.get(0));
            }
            queue.add(listAdded);
            map.put(key, listAdded);
        }
    }
}
