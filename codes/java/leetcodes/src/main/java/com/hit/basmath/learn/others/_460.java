package com.hit.basmath.learn.others;

import java.util.HashMap;
import java.util.Map;

/**
 * 460. LFU Cache
 * <p>
 * Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * <p>
 * Example:
 * <p>
 * LFUCache cache = new LFUCache( 2 // capacity);
 * <p>
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // returns 1
 * cache.put(3,3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.get(3);       // returns 3.
 * cache.put(4,4);    // evicts key 1.
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 */
public class _460 {
    class LFUCache {
        class Node {
            int key;
            int val;
            int freq;
            Node prev;
            Node next;

            public Node(int k, int v) {
                key = k;
                val = v;
                freq = 0;
                prev = null;
                next = null;
            }
        }

        Map<Integer, Node> map;
        Map<Integer, Node[]> freq;
        int size;
        int cap;

        public LFUCache(int capacity) {
            cap = capacity;
            size = 0;
            map = new HashMap<Integer, Node>();
            freq = new HashMap<Integer, Node[]>();
        }

        public int get(int key) {
            if (!map.containsKey(key) || cap == 0) return -1;
            Node n = map.get(key);
            n.prev.next = n.next;
            n.next.prev = n.prev;
            if (freq.get(n.freq)[0].next.freq == 0) freq.remove(n.freq);
            n.freq++;
            if (!freq.containsKey(n.freq)) {
                Node[] pair = new Node[2];
                pair[0] = new Node(0, 0);
                pair[1] = new Node(0, 0);
                pair[0].next = pair[1];
                pair[1].prev = pair[0];
                freq.put(n.freq, pair);
            }
            Node head = freq.get(n.freq)[0];
            Node tmp = head.next;
            head.next = n;
            n.prev = head;
            n.next = tmp;
            tmp.prev = n;
            return n.val;
        }

        public void put(int key, int value) {
            if (cap == 0) return;
            Node n = null;
            if (!map.containsKey(key)) {
                n = new Node(key, value);
                map.put(key, n);
                if (size == cap) {
                    int min = Integer.MAX_VALUE;
                    for (int num : freq.keySet()) {
                        min = Math.min(min, num);
                    }
                    Node[] pair = freq.get(min);
                    Node tail = pair[1];
                    map.remove(tail.prev.key);
                    tail.prev = tail.prev.prev;
                    tail.prev.next = tail;
                    if (pair[0].next == pair[1]) freq.remove(min);
                } else {
                    size++;
                }
            } else {
                n = map.get(key);
                n.val = value;
                n.prev.next = n.next;
                n.next.prev = n.prev;
                Node[] pair = freq.get(n.freq);
                if (pair[0].next == pair[1]) freq.remove(n.freq);
            }
            n.freq++;
            if (!freq.containsKey(n.freq)) {
                Node[] pair = new Node[2];
                pair[0] = new Node(0, 0);
                pair[1] = new Node(0, 0);
                pair[0].next = pair[1];
                pair[1].prev = pair[0];
                freq.put(n.freq, pair);
            }
            Node head = freq.get(n.freq)[0];
            Node tmp = head.next;
            head.next = n;
            n.prev = head;
            n.next = tmp;
            tmp.prev = n;
        }
    }
}
