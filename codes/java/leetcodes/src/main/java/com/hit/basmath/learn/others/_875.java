package com.hit.basmath.learn.others;

import java.util.Arrays;

/**
 * 875. Koko Eating Bananas
 * <p>
 * Koko loves to eat bananas.  There are N piles of bananas, the i-th pile has piles[i] bananas.  The guards have gone and will come back in H hours.
 * <p>
 * Koko can decide her bananas-per-hour eating speed of K.  Each hour, she chooses some pile of bananas, and eats K bananas from that pile.  If the pile has less than K bananas, she eats all of them instead, and won't eat any more bananas during this hour.
 * <p>
 * Koko likes to eat slowly, but still wants to finish eating all the bananas before the guards come back.
 * <p>
 * Return the minimum integer K such that she can eat all the bananas within H hours.
 * <p>
 * Example 1:
 * <p>
 * Input: piles = [3,6,7,11], H = 8
 * Output: 4
 * <p>
 * Example 2:
 * <p>
 * Input: piles = [30,11,23,4,20], H = 5
 * Output: 30
 * <p>
 * Example 3:
 * <p>
 * Input: piles = [30,11,23,4,20], H = 6
 * Output: 23
 * <p>
 * Note:
 * <p>
 * 1 <= piles.length <= 10^4
 * piles.length <= H <= 10^9
 * 1 <= piles[i] <= 10^9
 */
public class _875 {
    public int minEatingSpeed(int[] piles, int H) {
        Arrays.sort(piles);
        int lo = 0, hi = piles[piles.length - 1];
        while (lo < hi) {
            int mid = (lo + hi) / 2, cnt = 0;
            for (int p : piles)
                cnt += Math.ceil((double) p / mid);
            if (cnt > H) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
