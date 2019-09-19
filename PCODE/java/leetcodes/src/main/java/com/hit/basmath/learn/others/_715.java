package com.hit.basmath.learn.others;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 715. Range Module
 * <p>
 * A Range Module is a module that tracks ranges of numbers. Your task is to design and implement the following interfaces in an efficient manner.
 * <p>
 * addRange(int left, int right) Adds the half-open interval [left, right), tracking every real number in that interval. Adding an interval that partially overlaps with currently tracked numbers should add any numbers in the interval [left, right) that are not already tracked.
 * queryRange(int left, int right) Returns true if and only if every real number in the interval [left, right) is currently being tracked.
 * removeRange(int left, int right) Stops tracking every real number currently being tracked in the interval [left, right).
 * <p>
 * Example 1:
 * <p>
 * addRange(10, 20): null
 * removeRange(14, 16): null
 * queryRange(10, 14): true (Every number in [10, 14) is being tracked)
 * queryRange(13, 15): false (Numbers like 14, 14.03, 14.17 in [13, 15) are not being tracked)
 * queryRange(16, 17): true (The number 16 in [16, 17) is still being tracked, despite the remove operation)
 * <p>
 * Note:
 * <p>
 * A half open interval [left, right) denotes all real numbers left <= x < right.
 * 0 < left < right < 10^9 in all calls to addRange, queryRange, removeRange.
 * The total number of calls to addRange in a single test case is at most 1000.
 * The total number of calls to queryRange in a single test case is at most 5000.
 * The total number of calls to removeRange in a single test case is at most 1000.
 */
public class _715 {
    class RangeModule {
        private TreeMap<Integer, Integer> map;

        public RangeModule() {
            map = new TreeMap<>();
        }

        public void addRange(int left, int right) {
            if (right <= left) return;
            Integer start = map.floorKey(left);
            Integer end = map.floorKey(right);
            if (start == null && end == null) {
                map.put(left, right);
            } else if (start != null && map.get(start) >= left) {
                map.put(start, Math.max(map.get(end), Math.max(map.get(start), right)));
            } else {
                map.put(left, Math.max(map.get(end), right));
            }
            // clean up intermediate intervals
            Map<Integer, Integer> subMap = map.subMap(left, false, right, true);
            Set<Integer> set = new HashSet(subMap.keySet());
            map.keySet().removeAll(set);
        }

        public boolean queryRange(int left, int right) {
            Integer start = map.floorKey(left);
            if (start == null) return false;
            return map.get(start) >= right;
        }

        public void removeRange(int left, int right) {
            if (right <= left) return;
            Integer start = map.floorKey(left);
            Integer end = map.floorKey(right);
            if (end != null && map.get(end) > right) {
                map.put(right, map.get(end));
            }
            if (start != null && map.get(start) > left) {
                map.put(start, left);
            }
            // clean up intermediate intervals
            Map<Integer, Integer> subMap = map.subMap(left, true, right, false);
            Set<Integer> set = new HashSet(subMap.keySet());
            map.keySet().removeAll(set);

        }
    }
}
