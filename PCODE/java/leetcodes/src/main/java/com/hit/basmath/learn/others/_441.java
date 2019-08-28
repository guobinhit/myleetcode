package com.hit.basmath.learn.others;

/**
 * 441. Arranging Coins
 * <p>
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
 * <p>
 * Given n, find the total number of full staircase rows that can be formed.
 * <p>
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 * <p>
 * Example 1:
 * <p>
 * n = 5
 * <p>
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * <p>
 * Because the 3rd row is incomplete, we return 2.
 * <p>
 * Example 2:
 * <p>
 * n = 8
 * <p>
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * <p>
 * Because the 4th row is incomplete, we return 3.
 */
public class _441 {
    public int arrangeCoins(int n) {
        if (n < 1) {
            return 0;
        }
        int l = 1;
        int r = n;
        while (l + 1 < r) {
            int m = l + (r - l) / 2;
            long cnt = (long) (m + 1) * m / 2;
            if (cnt == (long) n) {
                return m;
            } else if (cnt < (long) n) {
                l = m;
            } else {
                r = m;
            }
        }
        return (long) (r + 1) * r / 2 <= (long) n ? r : l;
    }
}
