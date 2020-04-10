package com.hit.basmath.learn.others;

import java.util.PriorityQueue;

/**
 * 846. Hand of Straights
 * <p>
 * Alice has a hand of cards, given as an array of integers.
 * <p>
 * Now she wants to rearrange the cards into groups so that each group is size W, and consists of W consecutive cards.
 * <p>
 * Return true if and only if she can.
 * <p>
 * Example 1:
 * <p>
 * Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
 * Output: true
 * Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8].
 * <p>
 * Example 2:
 * <p>
 * Input: hand = [1,2,3,4,5], W = 4
 * Output: false
 * Explanation: Alice's hand can't be rearranged into groups of 4.
 * <p>
 * Note:
 * <p>
 * 1 <= hand.length <= 10000
 * 0 <= hand[i] <= 10^9
 * 1 <= W <= hand.length
 */
public class _846 {
    public boolean isNStraightHand(int[] hand, int W) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i : hand) {
            minHeap.add(i);
        }
        while (minHeap.size() != 0) {
            int start = minHeap.poll();
            for (int j = 1; j < W; j++) {
                if (minHeap.remove(start + j)) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
