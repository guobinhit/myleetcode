package com.hit.basmath.learn.others;

import java.util.HashSet;
import java.util.Set;

/**
 * 822. Card Flipping Game
 * <p>
 * On a table are N cards, with a positive integer printed on the front and back of each card (possibly different).
 * <p>
 * We flip any number of cards, and after we choose one card.
 * <p>
 * If the number X on the back of the chosen card is not on the front of any card, then this number X is good.
 * <p>
 * What is the smallest number that is good?  If no number is good, output 0.
 * <p>
 * Here, fronts[i] and backs[i] represent the number on the front and back of card i.
 * <p>
 * A flip swaps the front and back numbers, so the value on the front is now on the back and vice versa.
 * <p>
 * Example:
 * <p>
 * Input: fronts = [1,2,4,4,7], backs = [1,3,4,1,3]
 * Output: 2
 * Explanation: If we flip the second card, the fronts are [1,3,4,4,7] and the backs are [1,2,4,1,3].
 * We choose the second card, which has number 2 on the back, and it isn't on the front of any card, so 2 is good.
 * <p>
 * Note:
 * <p>
 * 1 <= fronts.length == backs.length <= 1000.
 * 1 <= fronts[i] <= 2000.
 * 1 <= backs[i] <= 2000.
 */
public class _822 {
    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> set = new HashSet<>();
        int n = fronts.length;
        for (int i = 0; i < n; i++) {
            if (fronts[i] == backs[i]) {
                set.add(fronts[i]);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (!set.contains(backs[i])) {
                min = Math.min(min, backs[i]);
            }
            if (!set.contains(fronts[i])) {
                min = Math.min(min, fronts[i]);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
