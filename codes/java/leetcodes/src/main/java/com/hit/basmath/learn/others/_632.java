package com.hit.basmath.learn.others;

import java.util.*;

/**
 * 632. Smallest Range Covering Elements from K Lists
 * <p>
 * You have k lists of sorted integers in ascending order. Find the smallest range that includes at least one number from each of the k lists.
 * <p>
 * We define the range [a,b] is smaller than range [c,d] if b-a < d-c or a < c if b-a == d-c.
 * <p>
 * Example 1:
 * <p>
 * Input: [[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
 * Output: [20,24]
 * <p>
 * Explanation:
 * List 1: [4, 10, 15, 24,26], 24 is in range [20,24].
 * List 2: [0, 9, 12, 20], 20 is in range [20,24].
 * List 3: [5, 18, 22, 30], 22 is in range [20,24].
 * <p>
 * Note:
 * <p>
 * The given list may contain duplicates, so ascending order means >= here.
 * 1 <= k <= 3500
 * -10^5 <= value of elements <= 10^5.
 */
public class _632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        // construct the priority queue
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int left = 0, right = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE; // mark the maximum value in the queue
        Map<Integer, Iterator<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            map.put(i, nums.get(i).iterator());
            int val = map.get(i).next();
            maxVal = Math.max(maxVal, val);
            pq.offer(new int[]{i, val});
        }
        while (pq.size() == nums.size()) {
            int[] top = pq.poll();
            int i = top[0], val = top[1];
            if (maxVal - val < right - left) {
                left = val;
                right = maxVal;
            }
            if (map.get(i).hasNext()) {
                int next = map.get(i).next();
                maxVal = Math.max(maxVal, next);
                pq.offer(new int[]{i, next});
            }
        }

        return new int[]{left, right};
    }
}
